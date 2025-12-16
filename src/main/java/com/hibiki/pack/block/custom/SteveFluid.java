package com.hibiki.pack.block.custom;

import com.hibiki.pack.block.CustomFluids;
import com.hibiki.pack.block.ModBlocks;
import com.hibiki.pack.block.ModFluids;
import com.hibiki.pack.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;

public abstract class SteveFluid extends CustomFluids {
    @Override
    public Fluid getStill() {
        return ModFluids.STEVE_FLUID;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_STEVE_FLUID;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.STEVE_FLUID_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.STEVE_FLUID.getDefaultState().with(FluidBlock.LEVEL,
                WaterFluid.getBlockStateLevel(state));
    }

    public static class Flowing extends SteveFluid{
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return (Integer)state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends SteveFluid{
        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
    }
}
