package com.pleahmacaka.sandbox.client.debug.imgui

import com.mojang.blaze3d.vertex.PoseStack
import imgui.ImGui
import imgui.ImGuiIO
import imgui.gl3.ImGuiImplGl3
import imgui.glfw.ImGuiImplGlfw
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component

var yet = IntArray(1)

class MagicTool : Screen(Component.nullToEmpty("MagicTool")) {

    private val window: Long = Minecraft.getInstance().window.window
    private val implGl3: ImGuiImplGl3 = ImGuiImplGl3()
    private val implGlfw: ImGuiImplGlfw = ImGuiImplGlfw()
    private val io: ImGuiIO

    init {
        val context = ImGui.createContext()
        ImGui.setCurrentContext(context)
        io = ImGui.getIO()
        implGlfw.init(window, false)
        implGl3.init("#version 150")
    }

    override fun isPauseScreen(): Boolean = false

    override fun render(pPoseStack: PoseStack, pMouseX: Int, pMouseY: Int, pPartialTick: Float) {

        implGlfw.newFrame()
        ImGui.newFrame()

        ImGui.begin("Hello")

        if (ImGui.button("ResetPos")) {
            ImGui.setNextWindowPos(
                Minecraft.getInstance().window.width * 0.5f,
                Minecraft.getInstance().window.height * 0.5f
            )
        }

        if (ImGui.button("width")) {
            Minecraft.getInstance().player!!.chat(Minecraft.getInstance().window.width.toString())
        }

        if (ImGui.button("height")) {
            Minecraft.getInstance().player!!.chat(Minecraft.getInstance().window.height.toString())
        }

        ImGui.sliderInt("POWER", yet, 1, 64)

        ImGui.end()
        ImGui.render()

        implGl3.renderDrawData(ImGui.getDrawData())

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick)
    }

}