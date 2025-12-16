package com.hibiki.pack;

import com.hibiki.pack.block.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class HibikiModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STEVE_FLUID, ModFluids.FLOWING_STEVE_FLUID,
                new SimpleFluidRenderHandler
                        (Identifier.of("hibikimod:block/steve_fluid_still"),
                        Identifier.of("hibikimod:block/steve_fluid_flow"),
                                0xA4DFFF));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STEVE_FLUID,ModFluids.FLOWING_STEVE_FLUID);
    }
}
