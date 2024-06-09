package net.peterlogan.javadim.item.custom;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry FALSE_COMMAND;
    public static final RegistryEntry FABRIC;

    public ModArmorMaterials() {
    }

    static {
        FALSE_COMMAND = register("diamond", (EnumMap) Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 3);
            map.put(ArmorItem.Type.HELMET, 1);
            map.put(ArmorItem.Type.BODY, 3);
        }), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.LEATHER});
        });
        FABRIC = register("diamond", (EnumMap) Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 3);
            map.put(ArmorItem.Type.HELMET, 1);
            map.put(ArmorItem.Type.BODY, 3);
        }), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.LEATHER});
        });

    }

    //region Helpers
    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability, RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(new Identifier("javadim", id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness, float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers

    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = ArmorItem.Type.values();
        int var10 = var9.length;

        for (int var11 = 0; var11 < var10; ++var11) {
            ArmorItem.Type type = var9[var11];
            enumMap.put(type, (Integer) defense.get(type));
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, new Identifier("javadim", id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }
    //endregion
}
