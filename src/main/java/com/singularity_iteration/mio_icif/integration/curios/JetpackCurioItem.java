package com.singularity_iteration.mio_icif.integration.curios;

import com.singularity_iteration.mio_icif.Items.Armor.mio_icif_chestplate_jetpack_elc;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class JetpackCurioItem implements ICurioItem {
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!(slotContext.entity() instanceof Player player)) return;
        if (!slotContext.identifier().equals("back")) return;

        ItemStack chestStack = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!chestStack.isEmpty() && chestStack.getItem() instanceof mio_icif_chestplate_jetpack_elc)
            return;

        if (stack.getItem() instanceof mio_icif_chestplate_jetpack_elc chest) {
            chest.tickJetpack(player, stack, player.level());
        }
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return slotContext.identifier().equals("back");
    }
}
