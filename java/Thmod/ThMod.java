package Thmod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.localization.MonsterStrings;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.RestartForChangesEffect;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import Thmod.Cards.Agarareta;
import Thmod.Cards.BlessingCards.BlessingOfScarlet;
import Thmod.Cards.BlessingCards.BlessingOfTime;
import Thmod.Cards.ColorlessCards.RidiculousThoughts;
import Thmod.Cards.DemonLordCradle;
import Thmod.Cards.DeriveCards.EasterEgg.MuyoNehan;
import Thmod.Cards.DeriveCards.EasterEgg.Scarlet;
import Thmod.Cards.DeriveCards.EasterEgg.ScarletsBlessing;
import Thmod.Cards.DeriveCards.EasterEgg.SpontaneousDetonation;
import Thmod.Cards.DeriveCards.EasterEgg.THsWorld;
import Thmod.Cards.DeriveCards.EasterEgg.TheWorld;
import Thmod.Cards.DeriveCards.Nothing;
import Thmod.Cards.DochyakuKami;
import Thmod.Cards.ElementCards.CondensedBubble;
import Thmod.Cards.ElementCards.RareCards.ElementInvoke;
import Thmod.Cards.ElementCards.RareCards.ElementMix;
import Thmod.Cards.ElementCards.RareCards.RoyalFlare;
import Thmod.Cards.ElementCards.RareCards.SilentSelene;
import Thmod.Cards.ElementCards.SpellCards.ElementExtend;
import Thmod.Cards.ElementCards.SpellCards.ElementalHarvester;
import Thmod.Cards.ElementCards.SpellCards.EmeraldMegalopolis;
import Thmod.Cards.ElementCards.SpellCards.ForestBlaze;
import Thmod.Cards.ElementCards.SpellCards.HydrogenousProminence;
import Thmod.Cards.ElementCards.SpellCards.JellyfishPrincess;
import Thmod.Cards.ElementCards.SpellCards.KenjiaNoSeki;
import Thmod.Cards.ElementCards.SpellCards.LavaCromlech;
import Thmod.Cards.ElementCards.SpellCards.MercuryPoison;
import Thmod.Cards.ElementCards.SpellCards.NoachianDeluge;
import Thmod.Cards.ElementCards.SpellCards.PhlogisticPillar;
import Thmod.Cards.ElementCards.SpellCards.Photosynthesis;
import Thmod.Cards.ElementCards.SpellCards.RoyalDiamondRing;
import Thmod.Cards.ElementCards.SpellCards.SatelliteHimawari;
import Thmod.Cards.ElementCards.SpellCards.StElmoPillar;
import Thmod.Cards.ElementCards.SpellCards.SunshineReflector;
import Thmod.Cards.ElementCards.SpellCards.WaterElf;
import Thmod.Cards.ElementCards.StickyBubble;
import Thmod.Cards.ElementCards.SummerFlame;
import Thmod.Cards.ElementCards.SummerRed;
import Thmod.Cards.ElementCards.UncommonCards.AutumnBlades;
import Thmod.Cards.ElementCards.UncommonCards.AutumnEdge;
import Thmod.Cards.ElementCards.UncommonCards.DiamondHardness;
import Thmod.Cards.ElementCards.UncommonCards.EmeraldCity;
import Thmod.Cards.ElementCards.UncommonCards.FallThrasher;
import Thmod.Cards.ElementCards.UncommonCards.FlashOfSpring;
import Thmod.Cards.ElementCards.UncommonCards.MidautumnSpear;
import Thmod.Cards.ElementCards.UncommonCards.SpringWind;
import Thmod.Cards.ElementCards.UncommonCards.StaticGreen;
import Thmod.Cards.ElementCards.WinterElement;
import Thmod.Cards.ElementCards.WipeMoisture;
import Thmod.Cards.HagoromoMizu;
import Thmod.Cards.Dash_Komeiji;
import Thmod.Cards.Defend_Komeiji;
import Thmod.Cards.InscribeRedSoul;
import Thmod.Cards.ItemCards.ByoukiHeiyu;
import Thmod.Cards.ItemCards.FusyokuKusuri;
import Thmod.Cards.ItemCards.HisouNoKenItem;
import Thmod.Cards.ItemCards.IbukiHisyaku;
import Thmod.Cards.ItemCards.MajikkuPosyun;
import Thmod.Cards.ItemCards.Namazu;
import Thmod.Cards.ItemCards.ReiGeki;
import Thmod.Cards.ItemCards.RyuuSei;
import Thmod.Cards.ItemCards.SaSen;
import Thmod.Cards.ItemCards.SanbutsuTenmizu;
import Thmod.Cards.ItemCards.SeigyoBou;
import Thmod.Cards.ItemCards.SutoppuWocchi;
import Thmod.Cards.JyouchiJin;
import Thmod.Cards.KeiseiJin;
import Thmod.Cards.KinbakuJin;
import Thmod.Cards.MakuraSeki;
import Thmod.Cards.Melting;
import Thmod.Cards.NingyouFukuhei;
import Thmod.Cards.NingyouKisou;
import Thmod.Cards.NingyouSP;
import Thmod.Cards.NingyouShinki;
import Thmod.Cards.NingyouSousou;
import Thmod.Cards.RareCards.HelanNingyou;
import Thmod.Cards.RareCards.MiraiBunraku;
import Thmod.Cards.RareCards.SemiAutomaton;
import Thmod.Cards.RareCards.ShanghaiNingyou;
import Thmod.Cards.RewardCards.MiserableFate;
import Thmod.Cards.RewardCards.RemiliaStretch;
import Thmod.Cards.RewardCards.ScarletDevil;
import Thmod.Cards.RikonNoKama;
import Thmod.Cards.Sabishigari;
import Thmod.Cards.Mishyaguji;
import Thmod.Cards.RareCards.AbyssNova;
import Thmod.Cards.RareCards.EverywhereHibernate;
import Thmod.Cards.SeekerWire;
import Thmod.Cards.SpellCards.CuteOchiyari;
import Thmod.Cards.SpellCards.DollofRoundTable;
import Thmod.Cards.SpellCards.DollsWar;
import Thmod.Cards.SpellCards.LemmingsParade;
import Thmod.Cards.SpellCards.PenglaiNingyou;
import Thmod.Cards.SpellCards.ReturnInanimateness;
import Thmod.Cards.SpellCards.TripWire;
import Thmod.Cards.UncommonCards.ArtfulChanter;
import Thmod.Cards.UncommonCards.EnMu;
import Thmod.Cards.UncommonCards.HagoromoKu;
import Thmod.Cards.RareCards.HisouTensoku;
import Thmod.Cards.RareCards.IceTornado;
import Thmod.Cards.RareCards.JigokuNoTaiyou;
import Thmod.Cards.RareCards.LunaDial;
import Thmod.Cards.RareCards.LunaticRedEyes;
import Thmod.Cards.RareCards.MunenMusou;
import Thmod.Cards.RareCards.MusouMyousyu;
import Thmod.Cards.RareCards.TenguhouSokujitsuken;
import Thmod.Cards.RareCards.TerribleSouvenir;
import Thmod.Cards.RareCards.WumiGaWareru;
import Thmod.Cards.RareCards.YuumeiNoKurin;
import Thmod.Cards.SpellCards.BurariHaieki;
import Thmod.Cards.SpellCards.DaiesanShikkaiKoroshi;
import Thmod.Cards.SpellCards.DeepEcologicalBomb;
import Thmod.Cards.SpellCards.DraculaCradle;
import Thmod.Cards.SpellCards.EasyMasterSpark;
import Thmod.Cards.SpellCards.EnshinRoten;
import Thmod.Cards.SpellCards.FusekiShinmei;
import Thmod.Cards.SpellCards.FuumaJin;
import Thmod.Cards.SpellCards.GensouFuubi;
import Thmod.Cards.SpellCards.HagoromoToki;
import Thmod.Cards.SpellCards.HangonChyou;
import Thmod.Cards.SpellCards.HappouKibaku;
import Thmod.Cards.SpellCards.HeartBreak;
import Thmod.Cards.SpellCards.Kamaitachi;
import Thmod.Cards.SpellCards.KokushiMusou;
import Thmod.Cards.SpellCards.KyoufuSaimin;
import Thmod.Cards.SpellCards.MirenKamai;
import Thmod.Cards.SpellCards.Mireniamu;
import Thmod.Cards.SpellCards.MissingPurplePower;
import Thmod.Cards.SpellCards.MoozeNoKiseki;
import Thmod.Cards.SpellCards.MoukoNaikei;
import Thmod.Cards.SpellCards.MusouTensei;
import Thmod.Cards.SpellCards.MusuNoTegata;
import Thmod.Cards.SpellCards.RapurasuNoMa;
import Thmod.Cards.SpellCards.RokkonShyoujyou;
import Thmod.Cards.SpellCards.SakuraHirame;
import Thmod.Cards.SpellCards.SakuyaNoSekai;
import Thmod.Cards.SpellCards.SeikonRyuuri;
import Thmod.Cards.SpellCards.SenseofCherryBlossom;
import Thmod.Cards.SpellCards.SpeartheGungnir;
import Thmod.Cards.SpellCards.TaihouKen;
import Thmod.Cards.SpellCards.TaihouTsuigeki;
import Thmod.Cards.SpellCards.TenkeiKisyou;
import Thmod.Cards.SpellCards.YomeiIkubaku;
import Thmod.Cards.UncommonCards.LittleLegion;
import Thmod.Cards.UncommonCards.NingyouChiyari;
import Thmod.Cards.UncommonCards.NingyouKasou;
import Thmod.Cards.UncommonCards.NingyouMusou;
import Thmod.Cards.UncommonCards.NingyouOkisou;
import Thmod.Cards.UncommonCards.NingyouYunhei;
import Thmod.Cards.UncommonCards.OoedoNingyou;
import Thmod.Cards.UncommonCards.SeekerDolls;
import Thmod.Cards.ShyakuBuku;
import Thmod.Cards.UncommonCards.SuitokuNoKyoryu;
import Thmod.Cards.UncommonCards.DemonsDinnerFork;
import Thmod.Cards.UncommonCards.FreezeToughMe;
import Thmod.Cards.UncommonCards.GasuOrimono;
import Thmod.Cards.UncommonCards.GroundStardust;
import Thmod.Cards.UncommonCards.HenyouMirume;
import Thmod.Cards.UncommonCards.HisouNoKen;
import Thmod.Cards.UncommonCards.KimairaNoYoku;
import Thmod.Cards.UncommonCards.KoKei;
import Thmod.Cards.UncommonCards.KokorosuKi;
import Thmod.Cards.UncommonCards.KouPou;
import Thmod.Cards.UncommonCards.MajikuruSanhai;
import Thmod.Cards.UncommonCards.MissingPower;
import Thmod.Cards.MusuNoYume;
import Thmod.Cards.UncommonCards.NarrowSpark;
import Thmod.Cards.RewardCards.PerfectMaid;
import Thmod.Cards.SpellCards.FinalSpark;
import Thmod.Cards.UncommonCards.RoshinSou;
import Thmod.Cards.UncommonCards.SatsujinDooru;
import Thmod.Cards.Strike_Komeiji;
import Thmod.Cards.UncommonCards.SeishiRoten;
import Thmod.Cards.UncommonCards.SelfTokamak;
import Thmod.Cards.UncommonCards.SenseofElegance;
import Thmod.Cards.UncommonCards.SenyouGoraku;
import Thmod.Cards.UncommonCards.TenguNoTaiko;
import Thmod.Cards.UncommonCards.VampireKiss;
import Thmod.Cards.RewardCards.VanishingEverything;
import Thmod.Cards.UncommonCards.YoukiSo;
import Thmod.Characters.KomeijiSatori;
import Thmod.Events.RoomOfDemon;
import Thmod.Events.RoomOfTime;
import Thmod.Patches.AbstractCardEnum;
import Thmod.Patches.CharacterEnum;
import Thmod.Relics.Grimoire;
import Thmod.Relics.KomeijisEye;
import Thmod.Relics.LinkosWocchi;
import Thmod.Relics.MigarariNingyou;
import Thmod.Relics.ReiryokuShyu;
import Thmod.Relics.ShirouKen;
import Thmod.Relics.SpellCardsRule;
import Thmod.Relics.SpellExtend;
import Thmod.Relics.SteinsOfFate;
import Thmod.Relics.ThirstyCross;
import basemod.BaseMod;
import basemod.DevConsole;
import basemod.ModLabeledToggleButton;
import basemod.ModPanel;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.interfaces.StartGameSubscriber;

import static basemod.DevConsole.logger;


@SpireInitializer
public class ThMod implements PostDungeonInitializeSubscriber, EditRelicsSubscriber, EditStringsSubscriber,PostInitializeSubscriber,EditKeywordsSubscriber,EditCharactersSubscriber,EditCardsSubscriber ,StartGameSubscriber {
    private static final String MODNAME = "Touhou Mod";
    private static final String AUTHOR = "hoykj";
    private static final String DESCRIPTION = "2018.04.14";
    public static boolean AliceOpen ;
    public static boolean SoundOpen ;
    public static boolean StartSelectOpen ;
    public static boolean MusicOpen ;
    public static boolean AllzhsOpen ;
    public static int blessingOfTime ;
    private float X;
    private float Y;
    private float IntervalY;
    private static final Color 古明地觉 = CardHelper.getColor(232, 123, 169);
    private static final Color Sp符卡 = CardHelper.getColor(239, 169, 23);
    private static final Color Item符卡 = CardHelper.getColor(231, 34, 0);
    private static final Color 彩蛋 = CardHelper.getColor(147, 147, 147);
    public static TextureAtlas orbAtlas;
    public static ArrayList<String> fightids = new ArrayList<>();
    public static ArrayList<String> upcardids = new ArrayList<>();
    public static ArrayList<String> weathers = new ArrayList<>();
    public static HashMap<String,Integer> removemap = new HashMap<>();
    public static HashMap<String,Integer> upcardmap = new HashMap<>();
    public static HashMap<String,AbstractCard> removedcardids = new HashMap<>();

    public static String komeijiCardImage(final String id) {
        return "images/cards/komeiji/" + id + ".png";
    }

    public static String spellCardImage(final String id) {
        return "images/cards/spcards/" + id + ".png";
    }

    public static String itemCardImage(final String id) {
        return "images/cards/itemcards/" + id + ".png";
    }

    public static String deriveCardImage(final String id) {
        return "images/cards/derivecards/" + id + ".png";
    }

    public static String colorlessCardImage(final String id) {
        return "images/cards/colorlesscards/" + id + ".png";
    }

    public static String statusCardImage(final String id) {
        return "images/cards/status/" + id + ".png";
    }

    public static String komeijiRelicImage(final String id) {
        return "images/relics/" + id + ".png";
    }
    public static String komeijiRelicOutlineImage(final String id) {
        return "images/relics/outline/" + id + ".png";
    }

    public static void initialize()  {
        DevConsole.logger.info("========================= 初始化ThMod所有数据 =========================");

        ThMod localThMod = new ThMod();

        fightids.add("KeiseiJin");
        fightids.add("KinbakuJin");
        fightids.add("JyouchiJin");
        fightids.add("HagoromoMizu");
        fightids.add("RikonNoKama");
        fightids.add("Sabishigari");
        fightids.add("DamonLordCradle");
        fightids.add("NarrowSpark");
        fightids.add("SeishiRoten");
        fightids.add("KokorosuKi");
        fightids.add("VampireKiss");
        fightids.add("MusuNoYume");
        fightids.add("HenyouMirume");
        fightids.add("MissingPower");
        fightids.add("KouPou");
        fightids.add("KoKei");
        fightids.add("MajikuruSanhai");
        fightids.add("DemonsDinnerFork");
        fightids.add("SenseofElegance");
        fightids.add("MusouMyousyu");
        fightids.add("LunaDial");
        fightids.add("HisouTensoku");
        fightids.add("WumiGaWareru");
        fightids.add("TerribleSouvenir");
        fightids.add("NingyouKasou");
        fightids.add("OoedoNingyou");
        fightids.add("ShanghaiNingyou");
        fightids.add("CondensedBubble");

        upcardids.add("FuumaJin");
        upcardids.add("HappouKibaku");
        upcardids.add("HagoromoToki");
        upcardids.add("SeikonRyuuri");
        upcardids.add("MirenKamai");
        upcardids.add("DraculaCradle");
        upcardids.add("FinalSpark");
        upcardids.add("EasyMasterSpark");
        upcardids.add("EnshinRoten");
        upcardids.add("SakuraHirame");
        upcardids.add("Mireniamu");
        upcardids.add("MusuNoTegata");
        upcardids.add("RapurasuNoMa");
        upcardids.add("MissingPurplePower");
        upcardids.add("TaihouKen");
        upcardids.add("TaihouTsuigeki");
        upcardids.add("MoukoNaikei");
        upcardids.add("DeepEcologicalBomb");
        upcardids.add("HeartBreak");
        upcardids.add("SpeartheGungnir");
        upcardids.add("SenseofCherryBlossom");
        upcardids.add("MusouTensei");
        upcardids.add("SakuyaNoSekai");
        upcardids.add("TenkeiKisyou");
        upcardids.add("MoozeNoKiseki");
        upcardids.add("KyoufuSaimin");
        upcardids.add("ReturnInanimateness");
        upcardids.add("PenglaiNingyou");
        upcardids.add("JellyfishPrincess");

        removemap.put("KeiseiJin",1);
        removemap.put("KinbakuJin",1);
        removemap.put("JyouchiJin",1);
        removemap.put("HagoromoMizu",2);
        removemap.put("RikonNoKama",3);
        removemap.put("Sabishigari",4);
        removemap.put("DamonLordCradle",5);
        removemap.put("NarrowSpark",6);
        removemap.put("SeishiRoten",7);
        removemap.put("KokorosuKi",8);
        removemap.put("VampireKiss",9);
        removemap.put("MusuNoYume",10);
        removemap.put("HenyouMirume",11);
        removemap.put("MissingPower",12);
        removemap.put("KouPou",13);
        removemap.put("KoKei",14);
        removemap.put("MajikuruSanhai",15);
        removemap.put("DemonsDinnerFork",16);
        removemap.put("SenseofElegance",17);
        removemap.put("MusouMyousyu",18);
        removemap.put("LunaDial",19);
        removemap.put("HisouTensoku",20);
        removemap.put("WumiGaWareru",21);
        removemap.put("TerribleSouvenir",22);
        removemap.put("NingyouKasou",23);
        removemap.put("OoedoNingyou",23);
        removemap.put("ShanghaiNingyou",24);
        removemap.put("CondensedBubble",25);

        upcardmap.put("FuumaJin",1);
        upcardmap.put("HappouKibaku",1);
        upcardmap.put("HagoromoToki",2);
        upcardmap.put("SeikonRyuuri",3);
        upcardmap.put("MirenKamai",4);
        upcardmap.put("DraculaCradle",5);
        upcardmap.put("FinalSpark",6);
        upcardmap.put("EasyMasterSpark",6);
        upcardmap.put("EnshinRoten",7);
        upcardmap.put("SakuraHirame",8);
        upcardmap.put("Mireniamu",9);
        upcardmap.put("MusuNoTegata",10);
        upcardmap.put("RapurasuNoMa",11);
        upcardmap.put("MissingPurplePower",12);
        upcardmap.put("TaihouKen",13);
        upcardmap.put("TaihouTsuigeki",13);
        upcardmap.put("MoukoNaikei",14);
        upcardmap.put("DeepEcologicalBomb",15);
        upcardmap.put("HeartBreak",16);
        upcardmap.put("SpeartheGungnir",16);
        upcardmap.put("SenseofCherryBlossom",17);
        upcardmap.put("MusouTensei",18);
        upcardmap.put("SakuyaNoSekai",19);
        upcardmap.put("TenkeiKisyou",20);
        upcardmap.put("MoozeNoKiseki",21);
        upcardmap.put("KyoufuSaimin",22);
        upcardmap.put("ReturnInanimateness",23);
        upcardmap.put("PenglaiNingyou",24);
        upcardmap.put("JellyfishPrincess",25);

        weathers.add("KaiSei");
        weathers.add("KiriSame");
        weathers.add("DonTen");
        weathers.add("SouTen");
        weathers.add("Haku");
        weathers.add("HanaGumo");
        weathers.add("NouMu");
        weathers.add("Yuki");
        weathers.add("TenkiYume");
        weathers.add("Soyuki");
        weathers.add("Fuuu");
        weathers.add("SeiRan");
        weathers.add("KawaGiri");
        weathers.add("TaiFuu");
        weathers.add("Nagi");
        weathers.add("DaiyamondoDasuto");
        weathers.add("Kousa");
        weathers.add("RetsuJitsu");
        weathers.add("Tsume");
        weathers.add("KyoKkou");

        try {
            final Properties defaults = new Properties();
            defaults.setProperty("AliceOpen", "true");
            defaults.setProperty("SoundOpen", "true");
            defaults.setProperty("StartSelectOpen", "true");
            defaults.setProperty("MusicOpen", "true");
            defaults.setProperty("AllzhsOpen", "false");
            defaults.setProperty("blessingOfTime", "0");
            final SpireConfig config = new SpireConfig("ThMod", "Common", defaults);
            ThMod.AliceOpen = config.getBool("AliceOpen");
            ThMod.SoundOpen = config.getBool("SoundOpen");
            ThMod.StartSelectOpen = config.getBool("StartSelectOpen");
            ThMod.MusicOpen = config.getBool("MusicOpen");
            ThMod.AllzhsOpen = config.getBool("AllzhsOpen");
            ThMod.blessingOfTime = config.getInt("blessingOfTime");
        } catch (IOException e) {
            e.printStackTrace();
        }


        DevConsole.logger.info("=========================== 初始化ThMod成功 ===========================");
        logger.info("========================正在注入新卡片相关信息========================");

        BaseMod.addColor(AbstractCardEnum.古明地觉.toString(),
                古明地觉, 古明地觉, 古明地觉, 古明地觉, 古明地觉, 古明地觉, 古明地觉,
                "images/cardui/512/bg_attack_komeiji.png", "images/cardui/512/bg_skill_komeiji.png",
                "images/cardui/512/bg_power_komeiji.png", "images/cardui/512/card_komeiji_orb.png",
                "images/cardui/1024/bg_attack_komeiji.png", "images/cardui/1024/bg_skill_komeiji.png",
                "images/cardui/1024/bg_power_komeiji.png", "images/cardui/1024/card_komeiji_orb.png");

        BaseMod.addColor(AbstractCardEnum.Sp符卡.toString(),
                Sp符卡, Sp符卡, Sp符卡, Sp符卡, Sp符卡, Sp符卡, Sp符卡,
                "images/cardui/512/bg_attack_spcard.png", "images/cardui/512/bg_skill_spcard.png",
                "images/cardui/512/bg_power_spcard.png", "images/cardui/512/card_spcard_orb.png",
                "images/cardui/1024/bg_attack_spcard.png", "images/cardui/1024/bg_skill_spcard.png",
                "images/cardui/1024/bg_power_spcard.png", "images/cardui/1024/card_spcard_orb.png");

        BaseMod.addColor(AbstractCardEnum.Item符卡.toString(),
                Item符卡, Item符卡, Item符卡, Item符卡, Item符卡, Item符卡, Item符卡,
                "images/cardui/512/bg_attack_itemcard.png", "images/cardui/512/bg_skill_itemcard.png",
                "images/cardui/512/bg_power_itemcard.png", "images/cardui/512/card_itemcard_orb.png",
                "images/cardui/1024/bg_attack_itemcard.png", "images/cardui/1024/bg_skill_itemcard.png",
                "images/cardui/1024/bg_power_itemcard.png", "images/cardui/1024/card_itemcard_orb.png");

        BaseMod.addColor(AbstractCardEnum.彩蛋.toString(),
                彩蛋, 彩蛋, 彩蛋, 彩蛋, 彩蛋, 彩蛋, 彩蛋,
                "images/cardui/512/bg_attack_derivecard.png", "images/cardui/512/bg_skill_derivecard.png",
                "images/cardui/512/bg_power_derivecard.png", "images/cardui/512/card_derivecard_orb.png",
                "images/cardui/1024/bg_attack_derivecard.png", "images/cardui/1024/bg_skill_derivecard.png",
                "images/cardui/1024/bg_power_derivecard.png", "images/cardui/1024/card_derivecard_orb.png");



        logger.info("========================注入新卡片相关信息成功========================");
    }
    public ThMod()
    {
        DevConsole.logger.info("============================ 监听初始化事件 ============================");
        BaseMod.subscribe(this);

        this.X = 400.0f;
        this.Y = 800.0f;
        this.IntervalY = -50.0f;

        DevConsole.logger.info("========================================================================");
    }

    public void receiveStartGame() {
        final String filepath = "saves" + File.separator + "KomeijiSatori.autosave";
        final boolean fileExists = Gdx.files.local(filepath).exists();
        if (!fileExists) {
            DevConsole.logger.info("==========================第一次载入初始化==========================");
            try {
                Default();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            DevConsole.logger.info("==========================第一次载入初始化o了==========================");
        }
        DevConsole.logger.info("=========================数据载入=========================");
        try {
            final Properties defaults = new Properties();
            defaults.setProperty("PointPower", "0");
            defaults.getProperty("TenmizuPower","0");
            defaults.setProperty("Hangongnum", "0");
            final SpireConfig config = new SpireConfig("ThMod", "Common", defaults);
            SpellCardsRule.pointcount.clear();
            SpellCardsRule.pointcount.add(config.getInt("PointPower"));
            SpellCardsRule.pointcount.add(config.getInt("TenmizuPower"));
            SpellCardsRule.Hangongnum = config.getInt("Hangongnum");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        DevConsole.logger.info("=========================数据载入也o了=========================");

    }

    public void receiveEditCharacters() {
        logger.info("========================正在注入Mod人物信息========================");

        logger.info("add " + CharacterEnum.KomeijiSatori.toString());

        BaseMod.addCharacter(
                KomeijiSatori.class, "古明地 觉", "CharacterName class string",
                AbstractCardEnum.古明地觉.toString(),"古明地 觉","images/ui/charSelect/komeijiButton.png", "images/ui/charSelect/komeijiPortrait.jpg",
                CharacterEnum.KomeijiSatori.toString());

        logger.info("========================注入Mod人物信息成功========================");
    }

    public void receiveEditRelics()
    {
        //BaseMod.addRelic(new WarGhost(), RelicType.SHARED);
    }

    public void receiveEditCards() {
        logger.info("=========================正在加载新的卡牌内容=========================");

        BaseMod.addCard(new Strike_Komeiji());
        BaseMod.addCard(new Defend_Komeiji());
        BaseMod.addCard(new Dash_Komeiji());
        BaseMod.addCard(new HagoromoMizu());
        BaseMod.addCard(new KeiseiJin());
        BaseMod.addCard(new KinbakuJin());
        BaseMod.addCard(new JyouchiJin());
//        BaseMod.addCard(new KochyouYume());
        BaseMod.addCard(new Agarareta());
        BaseMod.addCard(new DemonLordCradle());
//        BaseMod.addCard(new Demotivation());
        BaseMod.addCard(new DochyakuKami());
        BaseMod.addCard(new HagoromoMizu());
        BaseMod.addCard(new InscribeRedSoul());
//        BaseMod.addCard(new MagicStarsSword());
        BaseMod.addCard(new MakuraSeki());
        BaseMod.addCard(new Melting());
        BaseMod.addCard(new Sabishigari());
        BaseMod.addCard(new RikonNoKama());
        BaseMod.addCard(new Mishyaguji());
        BaseMod.addCard(new SuitokuNoKyoryu());
        BaseMod.addCard(new ShyakuBuku());


        BaseMod.addCard(new DemonsDinnerFork());
        BaseMod.addCard(new EnMu());
        BaseMod.addCard(new FreezeToughMe());
        BaseMod.addCard(new GasuOrimono());
        BaseMod.addCard(new GroundStardust());
        BaseMod.addCard(new HenyouMirume());
        BaseMod.addCard(new HisouNoKen());
        BaseMod.addCard(new KimairaNoYoku());
        BaseMod.addCard(new KoKei());
        BaseMod.addCard(new KokorosuKi());
        BaseMod.addCard(new KouPou());
        BaseMod.addCard(new MajikuruSanhai());
        BaseMod.addCard(new MissingPower());
        BaseMod.addCard(new MusuNoYume());
        BaseMod.addCard(new NarrowSpark());
        BaseMod.addCard(new PerfectMaid());
        BaseMod.addCard(new RoshinSou());
        BaseMod.addCard(new SatsujinDooru());
        BaseMod.addCard(new SeishiRoten());
        BaseMod.addCard(new SelfTokamak());
        BaseMod.addCard(new SenseofElegance());
        BaseMod.addCard(new SenyouGoraku());
        BaseMod.addCard(new TenguNoTaiko());
        BaseMod.addCard(new VampireKiss());
        BaseMod.addCard(new VanishingEverything());
        BaseMod.addCard(new YoukiSo());

        BaseMod.addCard(new AbyssNova());
        BaseMod.addCard(new EverywhereHibernate());
        BaseMod.addCard(new HagoromoKu());
        BaseMod.addCard(new HisouTensoku());
        BaseMod.addCard(new IceTornado());
        BaseMod.addCard(new JigokuNoTaiyou());
        BaseMod.addCard(new LunaDial());
        BaseMod.addCard(new LunaticRedEyes());
        BaseMod.addCard(new MunenMusou());
        BaseMod.addCard(new MusouMyousyu());
        BaseMod.addCard(new TenguhouSokujitsuken());
        BaseMod.addCard(new TerribleSouvenir());
        BaseMod.addCard(new WumiGaWareru());
        BaseMod.addCard(new YuumeiNoKurin());

        BaseMod.addCard(new ReiGeki());
        BaseMod.addCard(new MajikkuPosyun());
        BaseMod.addCard(new SutoppuWocchi());
        BaseMod.addCard(new SaSen());
        BaseMod.addCard(new ByoukiHeiyu());
        BaseMod.addCard(new FusyokuKusuri());
        BaseMod.addCard(new HisouNoKenItem());
        BaseMod.addCard(new IbukiHisyaku());
        BaseMod.addCard(new Namazu());
        BaseMod.addCard(new RyuuSei());
        BaseMod.addCard(new SanbutsuTenmizu());
        BaseMod.addCard(new SeigyoBou());

        BaseMod.addCard(new BurariHaieki());
        BaseMod.addCard(new DaiesanShikkaiKoroshi());
        BaseMod.addCard(new DeepEcologicalBomb());
        BaseMod.addCard(new DraculaCradle());
        BaseMod.addCard(new EasyMasterSpark());
        BaseMod.addCard(new EnshinRoten());
        BaseMod.addCard(new FinalSpark());
        BaseMod.addCard(new FusekiShinmei());
        BaseMod.addCard(new FuumaJin());
        BaseMod.addCard(new GensouFuubi());
        BaseMod.addCard(new HagoromoToki());
        BaseMod.addCard(new HangonChyou(0));
        BaseMod.addCard(new HappouKibaku());
        BaseMod.addCard(new HeartBreak());
        BaseMod.addCard(new Kamaitachi());
        BaseMod.addCard(new KokushiMusou());
        BaseMod.addCard(new KyoufuSaimin());
        BaseMod.addCard(new Mireniamu());
        BaseMod.addCard(new MirenKamai());
        BaseMod.addCard(new MissingPurplePower());
        BaseMod.addCard(new MoozeNoKiseki());
        BaseMod.addCard(new MoukoNaikei());
        BaseMod.addCard(new MusouTensei());
        BaseMod.addCard(new MusuNoTegata());
        BaseMod.addCard(new RapurasuNoMa());
        BaseMod.addCard(new RokkonShyoujyou());
        BaseMod.addCard(new SakuraHirame());
        BaseMod.addCard(new SakuyaNoSekai());
        BaseMod.addCard(new SeikonRyuuri());
        BaseMod.addCard(new SenseofCherryBlossom(0));
        BaseMod.addCard(new SpeartheGungnir());
        BaseMod.addCard(new TaihouKen());
        BaseMod.addCard(new TaihouTsuigeki());
        BaseMod.addCard(new TenkeiKisyou());
        BaseMod.addCard(new YomeiIkubaku());

        BaseMod.addCard(new Nothing());
        BaseMod.addCard(new TheWorld());
        BaseMod.addCard(new SpontaneousDetonation());
        BaseMod.addCard(new Scarlet());
        BaseMod.addCard(new MuyoNehan());
        BaseMod.addCard(new THsWorld());
        BaseMod.addCard(new ScarletsBlessing());

        BaseMod.addCard(new RidiculousThoughts());

        BaseMod.addCard(new BlessingOfTime());
        BaseMod.addCard(new BlessingOfScarlet());

        BaseMod.addCard(new MiserableFate());
        BaseMod.addCard(new RemiliaStretch());
        BaseMod.addCard(new ScarletDevil());

        if(ThMod.AliceOpen){
            BaseMod.addCard(new CuteOchiyari());
            BaseMod.addCard(new DollofRoundTable());
            BaseMod.addCard(new DollsWar());
            BaseMod.addCard(new LemmingsParade());
            BaseMod.addCard(new PenglaiNingyou());
            BaseMod.addCard(new ReturnInanimateness());
            BaseMod.addCard(new TripWire());

            BaseMod.addCard(new HelanNingyou());
            BaseMod.addCard(new MiraiBunraku());
            BaseMod.addCard(new SemiAutomaton());
            BaseMod.addCard(new ShanghaiNingyou());

            BaseMod.addCard(new ArtfulChanter());
            BaseMod.addCard(new LittleLegion());
            BaseMod.addCard(new NingyouChiyari());
            BaseMod.addCard(new NingyouKasou());
            BaseMod.addCard(new NingyouMusou());
            BaseMod.addCard(new NingyouOkisou());
            BaseMod.addCard(new NingyouYunhei());
            BaseMod.addCard(new OoedoNingyou());
            BaseMod.addCard(new SeekerDolls());

            BaseMod.addCard(new NingyouFukuhei());
            BaseMod.addCard(new NingyouKisou());
            BaseMod.addCard(new NingyouShinki());
            BaseMod.addCard(new NingyouSousou());
            BaseMod.addCard(new NingyouSP());
            BaseMod.addCard(new SeekerWire());

            BaseMod.addRelicToCustomPool(new Grimoire(), AbstractCardEnum.古明地觉.toString());
            BaseMod.addRelicToCustomPool(new MigarariNingyou(), AbstractCardEnum.古明地觉.toString());
        }
        else {
            BaseMod.addCard(new ElementalHarvester());
            BaseMod.addCard(new ElementExtend());
            BaseMod.addCard(new EmeraldMegalopolis());
            BaseMod.addCard(new ForestBlaze());
            BaseMod.addCard(new HydrogenousProminence());
            BaseMod.addCard(new JellyfishPrincess());
            BaseMod.addCard(new KenjiaNoSeki());
            BaseMod.addCard(new LavaCromlech());
            BaseMod.addCard(new MercuryPoison());
            BaseMod.addCard(new NoachianDeluge());
            BaseMod.addCard(new PhlogisticPillar());
            BaseMod.addCard(new Photosynthesis());
            BaseMod.addCard(new RoyalDiamondRing());
            BaseMod.addCard(new SatelliteHimawari());
            BaseMod.addCard(new StElmoPillar());
            BaseMod.addCard(new SunshineReflector());
            BaseMod.addCard(new WaterElf());

            BaseMod.addCard(new ElementInvoke());
            BaseMod.addCard(new ElementMix());
            BaseMod.addCard(new RoyalFlare());
            BaseMod.addCard(new SilentSelene());

            BaseMod.addCard(new AutumnBlades());
            BaseMod.addCard(new AutumnEdge());
            BaseMod.addCard(new DiamondHardness());
            BaseMod.addCard(new EmeraldCity());
            BaseMod.addCard(new FallThrasher());
            BaseMod.addCard(new FlashOfSpring());
            BaseMod.addCard(new MidautumnSpear());
            BaseMod.addCard(new SpringWind());
            BaseMod.addCard(new StaticGreen());

            BaseMod.addCard(new CondensedBubble());
            BaseMod.addCard(new StickyBubble());
            BaseMod.addCard(new SummerFlame());
            BaseMod.addCard(new SummerRed());
            BaseMod.addCard(new WinterElement());
            BaseMod.addCard(new WipeMoisture());

            BaseMod.addRelicToCustomPool(new Grimoire(), AbstractCardEnum.古明地觉.toString());
        }

        logger.info("=========================加载新的卡牌内容成功=========================");

        logger.info("=========================解锁卡牌=========================");
        UnlockTracker.unlockCard("Strike_Komeiji");
        UnlockTracker.unlockCard("Defend_Komeiji");
        UnlockTracker.unlockCard("VanishingEverything");
        UnlockTracker.unlockCard("PerfectMaid");
        UnlockTracker.unlockCard("HagoromoMizu");
        UnlockTracker.unlockCard("KeiseiJin");
        UnlockTracker.unlockCard("KinbakuJin");
        UnlockTracker.unlockCard("JyouchiJin");
        UnlockTracker.unlockCard("Agarareta");
        UnlockTracker.unlockCard("DemonLordCradle");
        UnlockTracker.unlockCard("DochyakuKami");
        UnlockTracker.unlockCard("HagoromoMizu");
        UnlockTracker.unlockCard("InscribeRedSoul");
        UnlockTracker.unlockCard("MakuraSeki");
        UnlockTracker.unlockCard("Melting");
        UnlockTracker.unlockCard("Sabishigari");
        UnlockTracker.unlockCard("RikonNoKama");
        UnlockTracker.unlockCard("Mishyaguji");
        UnlockTracker.unlockCard("SuitokuNoKyoryu");

        UnlockTracker.unlockCard("DemonsDinnerFork");
        UnlockTracker.unlockCard("FreezeToughMe");
        UnlockTracker.unlockCard("GasuOrimono");
        UnlockTracker.unlockCard("GroundStardust");
        UnlockTracker.unlockCard("HenyouMirume");
        UnlockTracker.unlockCard("HisouNoKen");
        UnlockTracker.unlockCard("KimairaNoYoku");
        UnlockTracker.unlockCard("KoKei");
        UnlockTracker.unlockCard("KokorosuKi");
        UnlockTracker.unlockCard("KouPou");
        UnlockTracker.unlockCard("MajikuruSanhai");
        UnlockTracker.unlockCard("MissingPower");
        UnlockTracker.unlockCard("MusuNoYume");
        UnlockTracker.unlockCard("NarrowSpark");
        UnlockTracker.unlockCard("RoshinSou");
        UnlockTracker.unlockCard("SatsujinDooru");
        UnlockTracker.unlockCard("SeishiRoten");
        UnlockTracker.unlockCard("SelfTokamak");
        UnlockTracker.unlockCard("SenseofElegance");
        UnlockTracker.unlockCard("SenyouGoraku");
        UnlockTracker.unlockCard("TenguNoTaiko");
        UnlockTracker.unlockCard("VampireKiss");

        UnlockTracker.unlockCard("AbyssNova");
        UnlockTracker.unlockCard("EverywhereHibernate");
        UnlockTracker.unlockCard("HagoromoKu");
        UnlockTracker.unlockCard("HisouTensoku");
        UnlockTracker.unlockCard("IceTornado");
        UnlockTracker.unlockCard("JigokuNoTaiyou");
        UnlockTracker.unlockCard("LunaDial");
        UnlockTracker.unlockCard("LunaticRedEyes");
        UnlockTracker.unlockCard("MunenMusou");
        UnlockTracker.unlockCard("MusouMyousyu");
        UnlockTracker.unlockCard("TenguhouSokujitsuken");
        UnlockTracker.unlockCard("TerribleSouvenir");
        UnlockTracker.unlockCard("WumiGaWareru");
        UnlockTracker.unlockCard("YuumeiNoKurin");

        UnlockTracker.unlockCard("ReiGeki");
        UnlockTracker.unlockCard("MajikkuPosyun");
        UnlockTracker.unlockCard("SutoppuWocchi");
        UnlockTracker.unlockCard("SaSen");
        UnlockTracker.unlockCard("ByoukiHeiyu");
        UnlockTracker.unlockCard("FusyokuKusuri");
        UnlockTracker.unlockCard("HisouNoKenItem");
        UnlockTracker.unlockCard("IbukiHisyaku");
        UnlockTracker.unlockCard("Namazu");
        UnlockTracker.unlockCard("RyuuSei");
        UnlockTracker.unlockCard("SanbutsuTenmizu");
        UnlockTracker.unlockCard("SeigyoBou");

        UnlockTracker.unlockCard("Nothing");

        UnlockTracker.unlockCard("RidiculousThoughts");

        if(ThMod.AliceOpen) {
            UnlockTracker.unlockCard("HelanNingyou");
            UnlockTracker.unlockCard("MiraiBunraku");
            UnlockTracker.unlockCard("SemiAutomaton");
            UnlockTracker.unlockCard("ShanghaiNingyou");

            UnlockTracker.unlockCard("ArtfulChanter");
            UnlockTracker.unlockCard("LittleLegion");
            UnlockTracker.unlockCard("NingyouChiyari");
            UnlockTracker.unlockCard("NingyouKasou");
            UnlockTracker.unlockCard("NingyouMusou");
            UnlockTracker.unlockCard("NingyouOkisou");
            UnlockTracker.unlockCard("NingyouYunhei");
            UnlockTracker.unlockCard("OoedoNingyou");
            UnlockTracker.unlockCard("SeekerDolls");

            UnlockTracker.unlockCard("NingyouFukuhei");
            UnlockTracker.unlockCard("NingyouKisou");
            UnlockTracker.unlockCard("NingyouShinki");
            UnlockTracker.unlockCard("NingyouSousou");
            UnlockTracker.unlockCard("NingyouSP");
            UnlockTracker.unlockCard("SeekerWire");
        }
        else{
            UnlockTracker.unlockCard("ElementInvoke");
            UnlockTracker.unlockCard("ElementMix");
            UnlockTracker.unlockCard("RoyalFlare");
            UnlockTracker.unlockCard("SilentSelene");

            UnlockTracker.unlockCard("AutumnBlades");
            UnlockTracker.unlockCard("AutumnEdge");
            UnlockTracker.unlockCard("DiamondHardness");
            UnlockTracker.unlockCard("EmeraldCity");
            UnlockTracker.unlockCard("FallThrasher");
            UnlockTracker.unlockCard("FlashOfSpring");
            UnlockTracker.unlockCard("MidautumnSpear");
            UnlockTracker.unlockCard("SpringWind");
            UnlockTracker.unlockCard("StaticGreen");

            UnlockTracker.unlockCard("CondensedBubble");
            UnlockTracker.unlockCard("StickyBubble");
            UnlockTracker.unlockCard("SummerFlame");
            UnlockTracker.unlockCard("SummerRed");
            UnlockTracker.unlockCard("WinterElement");
            UnlockTracker.unlockCard("WipeMoisture");
        }
        logger.info("=========================解锁卡牌成功=========================");

    }

    private void CreatePanel() throws IOException {
        final SpireConfig spireConfig = new SpireConfig("ThMod", "Common");
        final ModPanel settingsPanel = new ModPanel();
     //   final ModPanel settingsPanel = new ModPanel();
        settingsPanel.addButton(this.X, this.Y + 5*this.IntervalY, me -> {
            spireConfig.setBool("AliceOpen", ThMod.AliceOpen = !ThMod.AliceOpen);
            try {
                spireConfig.save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
//        final ModLabeledToggleButton AliceOpen = new ModLabeledToggleButton("启用爱丽丝卡组", this.X, this.Y + 4*this.IntervalY , Settings.CREAM_COLOR, FontHelper.charDescFont,ThMod.AliceOpen , settingsPanel, label -> {}, button -> {
//            spireConfig.setBool("AliceOpen", ThMod.AliceOpen = button.enabled);
//            CardCrawlGame.mainMenuScreen.optionPanel.effects.clear();
//            CardCrawlGame.mainMenuScreen.optionPanel.effects.add(new RestartForChangesEffect());
//
//            try {
//                spireConfig.save();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//            return;
//        });
//        settingsPanel.addUIElement((IUIElement)AliceOpen);

        final ModLabeledToggleButton SoundOpen = new ModLabeledToggleButton("mod自带音效", this.X, this.Y + 6*this.IntervalY , Settings.CREAM_COLOR, FontHelper.charDescFont,ThMod.SoundOpen , settingsPanel, label -> {}, button -> {
            spireConfig.setBool("SoundOpen", ThMod.SoundOpen = button.enabled);
            CardCrawlGame.mainMenuScreen.optionPanel.effects.clear();
            CardCrawlGame.mainMenuScreen.optionPanel.effects.add(new RestartForChangesEffect());

            try {
                spireConfig.save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
        settingsPanel.addUIElement(SoundOpen);

        final ModLabeledToggleButton MusicOpen = new ModLabeledToggleButton("mod自带bgm", this.X, this.Y + 7*this.IntervalY , Settings.CREAM_COLOR, FontHelper.charDescFont,ThMod.MusicOpen , settingsPanel, label -> {}, button -> {
            spireConfig.setBool("MusicOpen", ThMod.MusicOpen = button.enabled);
            CardCrawlGame.mainMenuScreen.optionPanel.effects.clear();
            CardCrawlGame.mainMenuScreen.optionPanel.effects.add(new RestartForChangesEffect());

            try {
                spireConfig.save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
        settingsPanel.addUIElement(MusicOpen);

        final ModLabeledToggleButton StartSelectOpen = new ModLabeledToggleButton("回合开始时选择符卡", this.X, this.Y + 8*this.IntervalY , Settings.CREAM_COLOR, FontHelper.charDescFont,ThMod.StartSelectOpen , settingsPanel, label -> {}, button -> {
            spireConfig.setBool("StartSelectOpen", ThMod.StartSelectOpen = button.enabled);
            CardCrawlGame.mainMenuScreen.optionPanel.effects.clear();
            CardCrawlGame.mainMenuScreen.optionPanel.effects.add(new RestartForChangesEffect());

            try {
                spireConfig.save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
        settingsPanel.addUIElement(StartSelectOpen);

        final ModLabeledToggleButton AllzhsOpen = new ModLabeledToggleButton("全中文卡牌名", this.X + 250, this.Y + 6*this.IntervalY , Settings.CREAM_COLOR, FontHelper.charDescFont,ThMod.AllzhsOpen , settingsPanel, label -> {}, button -> {
            spireConfig.setBool("AllzhsOpen", ThMod.AllzhsOpen = button.enabled);
            CardCrawlGame.mainMenuScreen.optionPanel.effects.clear();
            CardCrawlGame.mainMenuScreen.optionPanel.effects.add(new RestartForChangesEffect());

            try {
                spireConfig.save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
        settingsPanel.addUIElement(AllzhsOpen);

        Texture badgeTexture = new Texture(Gdx.files.internal("images/ThMod.png"));
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);
        settingsPanel.addLabel("设置", this.X, this.Y + 1*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("点击按钮切换扩展卡组，重启后生效", this.X, this.Y + 2*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("", 525.0f, this.Y + 4*this.IntervalY, me -> {
            if (ThMod.AliceOpen) {
                me.text = "启用爱丽丝卡组";
            }
            else {
                me.text = "启用帕秋莉卡组";
            }
            return;
        });
        settingsPanel.addLabel("本mod和其它部分mod可能存在部分冲突", this.X, this.Y + 10*this.IntervalY, (me) -> { });
//        settingsPanel.addLabel("适用版本: 1.游戏:7.13. 2.basemod:7.12. 3.ModTheSpire:2.8.0", this.X, this.Y + 11*this.IntervalY, (me) -> { });
        settingsPanel.addLabel("更新日志请见hoykj吧(贴吧)", this.X, this.Y + 11*this.IntervalY, (me) -> { });
        settingsPanel.addLabel("目前进度:", 1100f, this.Y + 2*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("卡组:基本完成", 1100f, this.Y + 3*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("遗物:做了个开头", 1100f, this.Y + 4*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("美工:做了个开头", 1100f, this.Y + 5*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("debug:在做", 1100f, this.Y + 6*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("特效:几乎没做", 1100f, this.Y + 7*this.IntervalY , (me) -> { });
        //settingsPanel.addLabel("设计:hoykj  编程:hoykj  绘图:hoykj", 400.0f, 500.0f, (me) -> { });
    }
    public void receivePostInitialize() {
        // Mod badge
        try {
            this.CreatePanel();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // Add relics
        BaseMod.addRelicToCustomPool(new KomeijisEye(), AbstractCardEnum.古明地觉.toString());
        BaseMod.addRelicToCustomPool(new SpellCardsRule(), AbstractCardEnum.古明地觉.toString());
        BaseMod.addRelicToCustomPool(new SpellExtend(), AbstractCardEnum.古明地觉.toString());
        BaseMod.addRelicToCustomPool(new ReiryokuShyu(), AbstractCardEnum.古明地觉.toString());
        RelicLibrary.add(new SteinsOfFate());
        RelicLibrary.add(new ThirstyCross());
        RelicLibrary.add(new ShirouKen());
        RelicLibrary.add(new LinkosWocchi());

        BaseMod.addEvent(RoomOfDemon.ID, RoomOfDemon.class, BaseMod.EventPool.THE_EXORDIUM);
        BaseMod.addEvent(RoomOfTime.ID, RoomOfTime.class, BaseMod.EventPool.THE_CITY);
    }

    public void receiveEditStrings()
    {
        DevConsole.logger.info("========================= 正在加载文本信息 =========================");

        if(AllzhsOpen){
            String cardStrings = Gdx.files.internal("localization/zhsCards.json").readString(String.valueOf(StandardCharsets.UTF_8));
            BaseMod.loadCustomStrings(CardStrings.class, cardStrings);
        }
        else {
            String cardStrings = Gdx.files.internal("localization/Cards.json").readString(String.valueOf(StandardCharsets.UTF_8));
            BaseMod.loadCustomStrings(CardStrings.class, cardStrings);
        }
        String relicStrings = Gdx.files.internal("localization/Relics.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        String powerStrings = Gdx.files.internal("localization/Power.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);
        String uiStrings = Gdx.files.internal("localization/UI.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(UIStrings.class, uiStrings);
        String orbStrings = Gdx.files.internal("localization/Orb.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(OrbStrings.class, orbStrings);
        String eventStrings = Gdx.files.internal("localization/Event.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(EventStrings.class, eventStrings);
        String monsterStrings = Gdx.files.internal("localization/Monster.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(MonsterStrings.class, monsterStrings);

        DevConsole.logger.info("========================================================================");
    }
    public void receivePostDungeonInitialize()
    {
//        if (!(AbstractDungeon.player.hasRelic("Letter Opener")))
//            new LetterOpener().instantObtain();
    }
    public void receiveEditKeywords()
    {
        DevConsole.logger.info("========================= 正在加载特性文本信息 =========================");
        BaseMod.addKeyword(new String[]{"擦弹","擦弹"}, "闪避伤害");
        BaseMod.addKeyword(new String[]{"符卡规则","符卡规则"}, "1.每个回合开始时,你将根据你的 #rp 点来获取SP卡. NL 2.获得的SP卡和你的手牌有关. NL 3.所有符卡具有 #y消耗 与 #y虚无 . NL 4.剩下的就靠你自己来摸索吧!");
        BaseMod.addKeyword(new String[]{"联想","联想"}, "这张卡不能被升级,但是可以在篝火处转换为另外的卡");
        BaseMod.addKeyword(new String[]{"替换","替换"}, "这种卡将会替换你手中的一张卡,在消耗后恢复.");
        BaseMod.addKeyword(new String[]{"回响","回响"}, "这张卡在消耗后会将一张复制加入你的手牌");
        BaseMod.addKeyword(new String[]{"蓄力","蓄力"}, "这张卡在使用后不会立刻触发效果,而是由你选择触发");
        BaseMod.addKeyword(new String[]{"固定","固定"}, "不受任何加成");
        BaseMod.addKeyword(new String[]{"紧缚灵","紧缚灵"}, "在它受到伤害时,每只紧缚灵会对它造成10点伤害并消失");
        BaseMod.addKeyword(new String[]{"天气","天气"}, "天气将为你提供额外效果");
        BaseMod.addKeyword(new String[]{"人偶","人偶"}, "爱丽丝制作的人偶,为什么会出现在这呢?");
        BaseMod.addKeyword(new String[]{"武装","武装"}, "普通人偶可以武装为枪兵,盾兵或弓兵.");
        BaseMod.addKeyword(new String[]{"枪兵人偶","枪兵人偶"}, "枪兵人偶会使你获得力量加成");
        BaseMod.addKeyword(new String[]{"盾兵人偶","盾兵人偶"}, "盾兵人偶会在回合结束提供格挡");
        BaseMod.addKeyword(new String[]{"弓兵人偶","弓兵人偶"}, "弓兵人偶会在回合结束造成随机目标的伤害");
        BaseMod.addKeyword(new String[]{"上海人偶","上海人偶"}, "上海人偶会使你获得力量加成,激发时造成全体伤害.(属于枪兵)");
        BaseMod.addKeyword(new String[]{"蓬莱人偶","蓬莱人偶"}, "上海人偶会使你获得力量加成,激发时造成全体伤害.(属于枪兵)");
        BaseMod.addKeyword(new String[]{"和兰人偶","和兰人偶"}, "和兰人偶会在回合结束提供格挡,激发后获得多层护甲.(属于盾兵)");
        BaseMod.addKeyword(new String[]{"额外行动","额外行动"}, "枪兵:对随机敌人造成3点伤害. 盾兵:给予2点格挡. 弓兵:每2个弓兵将为你恢复1点生命");
        BaseMod.addKeyword(new String[]{"元素","元素"}, "元素卡会生成或消耗相应的元素球.(多重元素即为消耗)");
        BaseMod.addKeyword(new String[]{"魔石","魔石"}, "在你使用元素牌时,如果你拥有对应元素的魔石,将消耗魔石,将那张卡再打出一次(再打出的卡不会获得或消耗元素球)");
        BaseMod.addKeyword(new String[]{"纯粹伤害","纯粹伤害"}, "纯粹伤害无视格挡,且不会受到反伤");
        BaseMod.addKeyword(new String[]{"祝福","祝福"}, "祝福卡会在抽到的时候消耗,并发动效果");
        BaseMod.addKeyword(new String[]{"永恒","永恒"}, "这张卡如果不在你的牌库,将会在战斗开始时加入你的牌库,包括下一场游戏(只能被特殊方法消除)");
    }

    public static void SavePointPower() throws IOException {
        final SpireConfig config = new SpireConfig("ThMod", "Common");
        config.setInt("PointPower",  SpellCardsRule.pointcount.get(0));
        config.setInt("TenmizuPower",  SpellCardsRule.pointcount.get(1));
        config.setInt("Hangongnum",  SpellCardsRule.Hangongnum);
        config.setInt("blessingOfTime",  ThMod.blessingOfTime);
        config.save();
    }

    public static void Default() throws IOException {
        final SpireConfig config = new SpireConfig("ThMod", "Common");
        config.setInt("PointPower", 0);
        config.setInt("TenmizuPower", 0);
        config.setInt("Hangongnum",0);
        config.save();
    }

    static {
        ThMod.SoundOpen = true;
        ThMod.AliceOpen = true;
        ThMod.StartSelectOpen = true;
        ThMod.MusicOpen = true;
        ThMod.AllzhsOpen = false;
        ThMod.blessingOfTime = 0;
    }

}
