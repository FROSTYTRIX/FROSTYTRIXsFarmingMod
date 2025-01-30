package net.frostytrix.frosty_farm.item;

import net.frostytrix.frosty_farm.FrostyFarm;
import net.frostytrix.frosty_farm.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FrostyFarm.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FOOD_TAB = CREATIVE_MODE_TAB.register(("food_tab"),
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOMATO.get()))
                    .title(Component.translatable("creative_tab.frosty_farm.food_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TOMATO.get());
                        output.accept(ModItems.TOMATO_SEEDS.get());
                        output.accept(ModItems.COFFEE_BERRIES.get());
                        output.accept(ModItems.ROASTED_COFFEE_BEANS.get());
                        output.accept(ModItems.COFFEE_MUG.get());
                        output.accept(ModBlocks.KITCHEN_COUNTER.get());
                    }).build());

    public  static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
