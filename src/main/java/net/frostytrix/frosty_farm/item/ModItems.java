package net.frostytrix.frosty_farm.item;

import net.frostytrix.frosty_farm.FrostyFarm;
import net.frostytrix.frosty_farm.block.ModBlocks;
import net.frostytrix.frosty_farm.item.custom.CoffeeMug;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FrostyFarm.MOD_ID);

    // Tomato
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)));

    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));

    //Coffee
    public static final RegistryObject<Item> COFFEE_BERRIES = ITEMS.register("coffee_berries",
            () -> new ItemNameBlockItem(ModBlocks.COFFEE_BERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.COFFEE_BERRIES)));

    public static final RegistryObject<Item> ROASTED_COFFEE_BEANS = ITEMS.register("roasted_coffee_beans",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> COFFEE_MUG = ITEMS.register("coffee_mug",
            () -> new CoffeeMug(new Item.Properties().food(ModFoodProperties.COFFEE_MUG)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
