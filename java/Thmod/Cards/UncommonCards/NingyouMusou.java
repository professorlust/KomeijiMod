package Thmod.Cards.UncommonCards;

import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import Thmod.Actions.common.ChangeOrbAction;
import Thmod.Actions.unique.ChooseAction;
import Thmod.Cards.AbstractSweepCards;
import Thmod.Cards.NingyouShinki;
import Thmod.Orbs.Helan;
import Thmod.Orbs.NingyouOrb;
import Thmod.Orbs.Penglai;
import Thmod.Orbs.Shanghai;
import Thmod.Orbs.TateNingyou;
import Thmod.Orbs.YariNingyou;
import Thmod.Orbs.YumiNingyou;

public class NingyouMusou extends AbstractSweepCards {
    public static final String ID = "NingyouMusou";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String[] EXTENDED_DESCRIPTION;
    private static final int COST = 0;

    public NingyouMusou() {
        super("NingyouMusou", NingyouMusou.NAME,  0, NingyouMusou.DESCRIPTION, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
    }

    public void use(final AbstractPlayer p, final AbstractMonster m) {
        final ChooseAction choice = new ChooseAction(this, m, NingyouMusou.EXTENDED_DESCRIPTION[0], true, 2);
        for (int i = (AbstractDungeon.player.orbs.size() - 1); i >= 0; i--) {
            final ArrayList<Integer> orbnum = new ArrayList<>();
            orbnum.clear();
            orbnum.add(i);
            if (AbstractDungeon.player.orbs.get(i) instanceof NingyouOrb) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[1], NingyouShinki.EXTENDED_DESCRIPTION[2], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                    AbstractDungeon.actionManager.addToTop(new GainEnergyAction(1));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof YariNingyou) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[3], NingyouShinki.EXTENDED_DESCRIPTION[4], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                    AbstractDungeon.actionManager.addToTop(new GainEnergyAction(1));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof TateNingyou) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[5], NingyouShinki.EXTENDED_DESCRIPTION[6], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                    AbstractDungeon.actionManager.addToTop(new GainEnergyAction(1));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof YumiNingyou) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[7], NingyouShinki.EXTENDED_DESCRIPTION[8], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                    AbstractDungeon.actionManager.addToTop(new GainEnergyAction(1));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof Shanghai) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[9], NingyouShinki.EXTENDED_DESCRIPTION[10], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                    AbstractDungeon.actionManager.addToTop(new GainEnergyAction(1));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof Penglai) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[11], NingyouShinki.EXTENDED_DESCRIPTION[12], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                    AbstractDungeon.actionManager.addToTop(new GainEnergyAction(1));
                });
            }
            if (AbstractDungeon.player.orbs.get(i) instanceof Helan) {
                choice.add(NingyouShinki.EXTENDED_DESCRIPTION[13], NingyouShinki.EXTENDED_DESCRIPTION[14], () -> {
                    AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                    AbstractDungeon.actionManager.addToTop(new GainEnergyAction(1));
                });
            }
        }
        AbstractDungeon.actionManager.addToBottom(choice);
    }

    @Override
    public ArrayList<AbstractSweepCards> getOpposite() {
        final ArrayList<AbstractSweepCards> opposite = new ArrayList<>();
        opposite.add(new NingyouKasou());
        opposite.add(new OoedoNingyou());
        return opposite;
    }

    public AbstractCard makeCopy() {
        return new NingyouMusou();
    }

    public void upgrade() {
        if (!(this.upgraded)) {
            this.upgradeName();
        }
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("NingyouMusou");
        NAME = NingyouMusou.cardStrings.NAME;
        DESCRIPTION = NingyouMusou.cardStrings.DESCRIPTION;
        EXTENDED_DESCRIPTION = NingyouMusou.cardStrings.EXTENDED_DESCRIPTION;
    }
}
