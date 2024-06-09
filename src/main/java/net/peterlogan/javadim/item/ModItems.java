package net.peterlogan.javadim.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.Javadim;
import net.peterlogan.javadim.item.custom.MetalDetectorItem;
import net.peterlogan.javadim.item.custom.ModFoodComponents;
import net.peterlogan.javadim.item.custom.ModToolMaterials;

public class ModItems {
    public static final Item SOYLENT = registerItem("soylent", new Item(new Item.Settings().food(ModFoodComponents.SOYLENT)));
    public static final Item SOY_BEAN = registerItem("soy_bean", new Item(new Item.Settings()));
    public static final Item MARX = registerItem("marx", new Item(new Item.Settings()));
    public static final Item FALSE_COMMAND_SCRAP = registerItem("false_command_scrap", new Item(new Item.Settings()));
    public static final Item FABRIC = registerItem("fabric", new Item(new Item.Settings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new Item.Settings().maxDamage(64)));

    public static final Item FALSE_COMMAND_SWORD = registerItem("false_command_sword", new SwordItem(ModToolMaterials.FALSE_COMMAND, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FALSE_COMMAND, 5, -1.8F))));
    public static final Item FALSE_COMMAND_SHOVEL = registerItem("false_command_shovel", new ShovelItem(ModToolMaterials.FALSE_COMMAND, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.FALSE_COMMAND, 3.0F, -3.0F))));
    public static final Item FALSE_COMMAND_PICKAXE = registerItem("false_command_pickaxe", new PickaxeItem(ModToolMaterials.FALSE_COMMAND, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FALSE_COMMAND, 1.0F, -2.8F))));
    public static final Item FALSE_COMMAND_AXE = registerItem("false_command_axe", new AxeItem(ModToolMaterials.FALSE_COMMAND, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FALSE_COMMAND, 7.0F, -3.0F))));
    public static final Item FALSE_COMMAND_HOE = registerItem("false_command_hoe", new HoeItem(ModToolMaterials.FALSE_COMMAND, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.FALSE_COMMAND, -3.0F, -1.0F))));

    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries){
    }

    private static void addItemsToWeaponItemGroup(FabricItemGroupEntries entries){
        entries.add(MARX);
    }
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Javadim.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Javadim.LOGGER.info("Registering Mod Items for " + Javadim.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToWeaponItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
