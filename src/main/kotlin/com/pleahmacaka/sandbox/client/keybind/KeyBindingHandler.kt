package com.pleahmacaka.sandbox.client.keybind

import com.pleahmacaka.sandbox.client.debug.imgui.MagicTool
import net.minecraft.client.KeyMapping
import net.minecraft.client.Minecraft
import net.minecraft.client.player.LocalPlayer
import net.minecraftforge.client.event.InputEvent
import org.lwjgl.glfw.GLFW

object KeyBindingHandler {

    fun onKeyInput(event: InputEvent.KeyInputEvent) {

        val key = KEYBINDINGS.find { keyMapping ->
            keyMapping.key.value == event.key
        } ?: return

        when (event.action) {
            GLFW.GLFW_PRESS -> {
                pressed(key)
            }
        }
    }

    private fun pressed(kb: KeyMapping) {

        val minecraft: Minecraft = Minecraft.getInstance() ?: return
        val player: LocalPlayer = Minecraft.getInstance().player ?: return

        when (kb) {
            KB_IMGUI -> minecraft.setScreen(MagicTool())

            KB_HOT_COMMAND -> player.chat("/setblock ~ ~-1 ~ minecraft:iron_block")
        }

    }

}