package net.nerf.mccourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ReturnHomeCommand {
    public ReturnHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes(this::execute)));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        boolean hasHomePos = player.getPersistentData().getIntArray("mccourse.homepos").length != 0;

        if (hasHomePos) {
            int[] playerPos = player.getPersistentData().getIntArray("mccourse.homepos");
            player.teleportTo(playerPos[0], playerPos[1], playerPos[2]);

            context.getSource().sendSuccess(()-> Component.literal("Player returned Home!"), true);
            return 1;
        } else {
            context.getSource().sendFailure(Component.literal("No Home Position Set!"));
            return -1;
        }
    }
}
