package nachiten.mari.mod.foods;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class CocainaFood {
    public static final StatusEffectInstance efectoVelocidad = new StatusEffectInstance(StatusEffects.SPEED, 1200, 1);
    public static final StatusEffectInstance efectoSalto = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200, 1);

    public static final FoodComponent COCAINA_COMIDA = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.3f).statusEffect(efectoVelocidad, 0.75f).statusEffect(efectoSalto, 0.75f).alwaysEdible().build();
}
