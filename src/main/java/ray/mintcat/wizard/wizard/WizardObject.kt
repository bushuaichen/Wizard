package ray.mintcat.wizard.wizard

import io.izzel.taboolib.module.db.local.LocalPlayer
import org.bukkit.entity.Player

object WizardObject {

    fun getIntegral(player: Player?, integral: Any, def: Any): Any {
        val yaml = LocalPlayer.get(player)
        return yaml["Wizard.list.$integral", def] ?: def
    }

    fun setIntegral(player: Player, integral: Any, value: Any) {
        val yaml = LocalPlayer.get(player)
        yaml["Wizard.list.$integral"] = value
    }

    fun addIntegral(player: Player, integral: Any, value: Int) {
        val yaml = LocalPlayer.get(player)
        val info = yaml.getInt("Wizard.list.$integral", 0)
        yaml["Wizard.list.$integral"] = info + value
    }

    fun takeIntegral(player: Player, integral: Any, value: Int) {
        val yaml = LocalPlayer.get(player)
        val info = yaml.getInt("Wizard.list.$integral", 0)
        yaml["Wizard.list.$integral"] = info - value
    }
}