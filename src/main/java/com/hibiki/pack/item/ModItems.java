package com.hibiki.pack.item;

import com.hibiki.pack.HibikiMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLACK_TEA = registerItems("black_tea", new Item(new Item.Settings()));
    public static final Item KIM_IL_SUNG_PORTRAIT = registerItems("kim_il_sung_portrait", new Item(new Item.Settings()));
    public static final Item KIM_JUNG_IL_PORTRAIT = registerItems("kim_jung_il_portrait", new Item(new Item.Settings()));
    private static Item registerItems(String id, Item item){
        return Registry.register(Registries.ITEM,Identifier.of(HibikiMod.MOD_ID,id),item);
    }
    private static void addItemToItemGroup(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(BLACK_TEA);
        fabricItemGroupEntries.add(KIM_IL_SUNG_PORTRAIT);
        fabricItemGroupEntries.add(KIM_JUNG_IL_PORTRAIT);
    }
    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToItemGroup);
        HibikiMod.LOGGER.info("Registering items.");
    }
}
