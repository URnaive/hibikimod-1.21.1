package com.hibiki.pack.block;

import com.hibiki.pack.HibikiMod;
import com.hibiki.pack.block.custom.SteveFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid FLOWING_STEVE_FLUID = register("flowing_steve_fluid", new SteveFluid.Flowing());
    public static final FlowableFluid STEVE_FLUID = register("steve_fluid", new SteveFluid.Still());
    private static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registries.FLUID, Identifier.of(HibikiMod.MOD_ID, id), value);
    }

    static {
        for (Fluid fluid : Registries.FLUID) {
            for (FluidState fluidState : fluid.getStateManager().getStates()) {
                Fluid.STATE_IDS.add(fluidState);
            }
        }
    }

    public static void registerModFluids(){

    }

}
