package Thmod.Cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Thmod.ThMod.AllzhsOpen;

public class DemonLordCradle extends AbstractKomeijiCards {
    public static final String ID = "DemonLordCradle";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;
    private static final int ATTACK_DMG = 8;
    private static final int BASE_DRAW = 1;

    public DemonLordCradle() {
        super("DemonLordCradle", DemonLordCradle.NAME,  1, DemonLordCradle.DESCRIPTION, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = 8;
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new DemonLordCradle();
    }

    public void upgrade() {
        if (!(this.upgraded)) {
            if(AllzhsOpen)
                this.name = "回忆「恶魔领主的摇篮」";
            else
                this.name = "回忆「Demon King Cradle」";
            this.initializeTitle();
            this.upgradeDamage(1);
            this.upgradeMagicNumber(1);
            this.timesUpgraded += 1;
            this.upgraded = true;
        }
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("DemonLordCradle");
        NAME = DemonLordCradle.cardStrings.NAME;
        DESCRIPTION = DemonLordCradle.cardStrings.DESCRIPTION;
    }
}
