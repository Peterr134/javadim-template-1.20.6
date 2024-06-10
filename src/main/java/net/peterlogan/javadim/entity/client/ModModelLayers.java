package net.peterlogan.javadim.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.Javadim;

public class ModModelLayers {

    public static final EntityModelLayer JAVACUPINE =
            new EntityModelLayer(new Identifier(Javadim.MOD_ID, "javacupine"), "main");
}
