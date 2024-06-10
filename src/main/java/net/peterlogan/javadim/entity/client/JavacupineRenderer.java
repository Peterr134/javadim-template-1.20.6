package net.peterlogan.javadim.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.Javadim;
import net.peterlogan.javadim.entity.custom.JavacupineEntity;

public class JavacupineRenderer extends MobEntityRenderer<JavacupineEntity, JavacupineModel<JavacupineEntity>> {

    private static final Identifier TEXTURE = new Identifier(Javadim.MOD_ID, "textures/entity/javacupine.png");
    public JavacupineRenderer(EntityRendererFactory.Context context) {
        super(context, new JavacupineModel<>(context.getPart(ModModelLayers.JAVACUPINE)), 0.6f);
    }

    @Override
    public Identifier getTexture(JavacupineEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(JavacupineEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        }else{
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
