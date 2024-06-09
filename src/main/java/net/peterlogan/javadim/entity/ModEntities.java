package net.peterlogan.javadim.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.Javadim;
import net.peterlogan.javadim.entity.custom.JavacupineEntity;

public class ModEntities {
    public static final EntityType<JavacupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE, new Identifier(Javadim.MOD_ID, "porcupine"),
            EntityType.Builder.create(JavacupineEntity::new, SpawnGroup.CREATURE).dimensions(1f,1f).build());
}
