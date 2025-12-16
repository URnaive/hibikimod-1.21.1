package com.hibiki.pack.item;

import com.hibiki.pack.HibikiMod;
import com.hibiki.pack.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    /*public static final RegistryKey<ItemGroup> HIBIKIMOD_GROUP = register("hibikimod_group");
    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(HibikiMod.MOD_ID,id));
    }
    public static void registerModItemGroups(){
        Registry.register(Registries.ITEM_GROUP, HIBIKIMOD_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.hibikimod.hibikimod_group"))
                        .icon(() -> new ItemStack(ModItems.BLACK_TEA))
                        .entries(((displayContext, entries) -> {
                            entries.add(ModItems.BLACK_TEA);
                        })).build()
                        );
        HibikiMod.LOGGER.info("Resistering the mod item group.");
    }*/
    public static final ItemGroup HIBIKIMOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HibikiMod.MOD_ID, "hibikimod_group"),
            ItemGroup.create(null, -1)
                    .displayName(Text.translatable("itemGroup.hibikimod.hibikimod_group"))
                    .icon(() -> new ItemStack(ModItems.BLACK_TEA))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.BLACK_TEA);
                        entries.add(ModItems.KIM_IL_SUNG_PORTRAIT);
                        entries.add(ModItems.KIM_JUNG_IL_PORTRAIT);

                        entries.add(ModBlocks.ICE_BLACK_TEA);
                        entries.add(ModBlocks.MANEKI_NEKO);
                        entries.add(ModBlocks.YELLOEW_FLOOR_TILE);
                        entries.add(ModBlocks.KIM_IL_SUNG_PORTRAITBLOCK);
                        entries.add(ModBlocks.KIM_JUNG_IL_PORTRAITBLOCK);
                    })).build());
    public static void registerModItemGroups(){
        HibikiMod.LOGGER.info("Resistering the mod item group.");
    }
}
