package Thmod.Cards.UncommonCards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import Thmod.Actions.common.ChangeOrbAction;
import Thmod.Actions.unique.ChooseAction;
import Thmod.Cards.AbstractKomeijiCards;
import Thmod.Cards.NingyouShinki;
import Thmod.Orbs.Helan;
import Thmod.Orbs.NingyouOrb;
import Thmod.Orbs.Penglai;
import Thmod.Orbs.Shanghai;
import Thmod.Orbs.TateNingyou;
import Thmod.Orbs.YariNingyou;
import Thmod.Orbs.YumiNingyou;

public class ArtfulChanter extends AbstractKomeijiCards {
    public static final String ID = "ArtfulChanter";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String[] EXTENDED_DESCRIPTION;
    private static final int COST = 1;

    public ArtfulChanter() {
        super("ArtfulChanter", ArtfulChanter.NAME,  1, ArtfulChanter.DESCRIPTION, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        final ChooseAction choice = new ChooseAction(this, m, ArtfulChanter.EXTENDED_DESCRIPTION[0], false, 1);
        for (int i = (AbstractDungeon.player.orbs.size() - 1); i >= 0; i--) {
            final ArrayList<Integer> orbnum = new ArrayList<>();
            orbnum.clear();
            orbnum.add(i);
            if (AbstractDungeon.player.orbs.get(i) instanceof NingyouOrb) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[1], NingyouShinki.EXTENDED_DESCRIPTION[2], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                    AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.magicNumber));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof YariNingyou) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[3], NingyouShinki.EXTENDED_DESCRIPTION[4], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                    AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.magicNumber));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof TateNingyou) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[5], NingyouShinki.EXTENDED_DESCRIPTION[6], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                    AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.magicNumber));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof YumiNingyou) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[7], NingyouShinki.EXTENDED_DESCRIPTION[8], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                    AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.magicNumber));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof Shanghai) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[9], NingyouShinki.EXTENDED_DESCRIPTION[10], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                    AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.magicNumber));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof Penglai) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[11], NingyouShinki.EXTENDED_DESCRIPTION[12], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                    AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.magicNumber));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof Helan) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[13], NingyouShinki.EXTENDED_DESCRIPTION[14], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                    AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.magicNumber));
                });
            }
        }
        AbstractDungeon.actionManager.addToBottom(choice);
    }

    public AbstractCard makeCopy() {
        return new ArtfulChanter();
    }

    public void upgrade() {
        if (!(this.upgraded)) {
            this.upgradeName();
            this.upgradeBaseCost(0);
        }
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("ArtfulChanter");
        NAME = ArtfulChanter.cardStrings.NAME;
        DESCRIPTION = ArtfulChanter.cardStrings.DESCRIPTION;
        EXTENDED_DESCRIPTION = ArtfulChanter.cardStrings.EXTENDED_DESCRIPTION;
    }
}
