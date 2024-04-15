package net.nerf.mccourse.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nerf.mccourse.MCCourseMod;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Enchantment> LIGHTNING_STRIKE_ENCHANTMENT = ENCHANTMENTS.register("lightning_strike",
            () -> new LightningStrikeEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON,
                    EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

}
