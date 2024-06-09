package net.peterlogan.javadim;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.peterlogan.javadim.entity.ModEntities;
import net.peterlogan.javadim.entity.client.ModModelLayers;
import net.peterlogan.javadim.entity.client.PorcupineModel;
import net.peterlogan.javadim.entity.client.JavacupineRenderer;

public class JavadimClient implements ClientModInitializer{
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.register(ModEntities.PORCUPINE, JavacupineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.JAVACUPINE, PorcupineModel::getTexturedModelData);
    }
}
