package com.pleahmacaka.sandbox.client.keybind

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.minecraftforge.client.settings.KeyConflictContext
import org.lwjgl.glfw.GLFW

const val CATEGORY = "PleahMaCaka's MagicTool"

val KB_IMGUI = KeyMapping(
    "Open Magic Tool",
    KeyConflictContext.IN_GAME,
    InputConstants.Type.KEYSYM,
    GLFW.GLFW_KEY_INSERT,
    CATEGORY
)

val KB_HOT_COMMAND = KeyMapping(
    "HotCommand",
    KeyConflictContext.IN_GAME,
    InputConstants.Type.KEYSYM,
    GLFW.GLFW_KEY_C,
    CATEGORY
)

val KEYBINDINGS = hashSetOf(KB_IMGUI, KB_HOT_COMMAND)