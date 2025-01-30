package net.frostytrix.frosty_farm.datagen;

import net.frostytrix.frosty_farm.FrostyFarm;
import net.frostytrix.frosty_farm.block.ModBlocks;
import net.frostytrix.frosty_farm.block.custom.CoffeeBerryBushBlock;
import net.frostytrix.frosty_farm.block.custom.TomatoCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FrostyFarm.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //ex : blockWithItem(ModBlocks.BLOCK)
        makeCrop(((CropBlock) ModBlocks.TOMATO_CROP.get()), "tomato_crop_stage", "tomato_crop_stage");
        makeBush(((CoffeeBerryBushBlock) ModBlocks.COFFEE_BERRY_BUSH.get()), "coffee_berry_bush_stage", "coffee_berry_bush_stage");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(CoffeeBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(FrostyFarm.MOD_ID, "block/coffee_berry_bush/" + textureName + state.getValue(CoffeeBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    private void makeCrop(CropBlock cropBlock, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, cropBlock, modelName, textureName);

        getVariantBuilder(cropBlock).forAllStates(function);
    }


    private ConfiguredModel[] states(BlockState state, CropBlock cropBlock, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) cropBlock).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(FrostyFarm.MOD_ID, "block/tomato_crop/" + textureName + state.getValue(((TomatoCropBlock) cropBlock).getAgeProperty())))
                .renderType("cutout"));
        return models;
    }
}
