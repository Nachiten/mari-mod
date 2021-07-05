package nachiten.mari.mod.foods;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class PorroFood {
    public static final StatusEffectInstance efectoLentitud = new StatusEffectInstance(StatusEffects.SLOWNESS, 1200, 1);
    public static final StatusEffectInstance efectoFatiga = new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1200, 1);

    public static final FoodComponent PORRO_COMIDA = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.3f).statusEffect(efectoLentitud, 0.75f).statusEffect(efectoFatiga, 0.75f).alwaysEdible().build();
}
