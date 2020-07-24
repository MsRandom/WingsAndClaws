package net.msrandom.wings.item;

import net.minecraft.item.*;
import net.minecraftforge.fml.common.thread.EffectiveSide;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.msrandom.wings.WingsAndClaws;
import net.msrandom.wings.WingsSounds;
import net.msrandom.wings.block.WingsBlocks;
import net.msrandom.wings.block.entity.WingsBlockEntities;
import net.msrandom.wings.client.ClientEventHandler;
import net.msrandom.wings.client.renderer.tileentity.NestItemRenderer;
import net.msrandom.wings.client.renderer.tileentity.PlowheadShieldRenderer;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class WingsItems {
    public static final DeferredRegister<Item> REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, WingsAndClaws.MOD_ID);
    //Anonymous item classes
    public static final ItemGroup GROUP = new ItemGroup(WingsAndClaws.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(DUMPY_EGG_DRAKE_EGG);
        }
    };
    public static final Item GLISTENING_GLACIAL_SHRIMP = register("glistening_glacial_shrimp", new Item(new Item.Properties().group(GROUP)) {
        @Override
        public boolean hasGlint(ItemStack stack) {
            return true;
        }
    });

    //Items
    public static final Item DRAGON_MEAT = register("dragon_meat", new Item(new Item.Properties().food(WingsFoods.DRAGON_MEAT).group(GROUP)));
    public static final Item COOKED_DRAGON_MEAT = register("cooked_dragon_meat", new Item(new Item.Properties().food(WingsFoods.COOKED_DRAGON_MEAT).group(GROUP)));
    public static final Item GLACIAL_SHRIMP = register("glacial_shrimp", new Item(new Item.Properties().group(GROUP)));
    public static final Item ICY_PLOWHEAD_EGG = register("icy_plowhead_egg", new PlowheadEggItem());
    public static final Item DUMPY_EGG_DRAKE_EGG = register("dumpy_egg_drake_egg", new NestEggItem(WingsBlocks.DED_NEST));
    public static final Item MIMANGO_EGG = register("mimango_egg", new MimangoEggItem());
    //public static final Item HATCHET_BEAK_EGG = register("hatchet_beak_egg", new NestEggItem(WingsBlocks.HB_NEST));
    //public static final Item HATCHET_BEAK_CREST = register("hatchet_beak_crest", new Item(new Item.Properties().group(GROUP)));
    //public static final Item CREST_HATCHET = register("crest_hatchet", new AxeItem(ItemTier.DIAMOND, 5.0F, -3.0F, new Item.Properties().group(GROUP)));
    public static final Item ICY_PLOWHEAD_SHIELD = register("icy_plowhead_shield", new ShieldItem(getWithISTER(new Item.Properties().group(GROUP).maxDamage(678), () -> PlowheadShieldRenderer::new)));
    public static final Item HORN_HORN = register("horn_horn", new HornHornItem());
    public static final Item PLOWHEAD_HORN = register("plowhead_horn", new Item(new Item.Properties().group(GROUP)));

    public static final Item MUSIC_DISC_BLISSFUL_DUNES = register("music_disc_blissful_dunes", new MusicDiscItem(1, () -> WingsSounds.MUSIC_BLISSFUL_DUNES, new Item.Properties().group(GROUP).maxStackSize(1).rarity(Rarity.RARE)));

    //Custom block items
    static {
        register("ded_nest", new BlockItem(WingsBlocks.DED_NEST, getWithISTER(new Item.Properties(), () -> () -> new NestItemRenderer(WingsBlockEntities.DED_NEST))));
        register("hb_nest", new BlockItem(WingsBlocks.HB_NEST, getWithISTER(new Item.Properties(), () -> () -> new NestItemRenderer(WingsBlockEntities.HB_NEST))));
        register("mango", new BlockItem(WingsBlocks.MANGO_BUNCH, new Item.Properties().group(GROUP).food(WingsFoods.MANGO)));
    }

    private static Item register(String name, Item item) {
        REGISTRY.register(name, () -> item);
        return item;
    }

    private static Item.Properties getWithISTER(Item.Properties properties, Supplier<Callable<Object>> ister) {
        return EffectiveSide.get().isClient() ? ClientEventHandler.getWithISTER(properties, ister) : properties;
    }
}
