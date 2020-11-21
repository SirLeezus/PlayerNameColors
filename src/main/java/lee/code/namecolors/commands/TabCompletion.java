package lee.code.namecolors.commands;

import lee.code.namecolors.NameColors;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class TabCompletion implements TabCompleter {
    private final List<String> commands = Arrays.asList("glow", "reload");
    private final List<String> blank = new ArrayList<>();

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        NameColors plugin = NameColors.getPlugin();
        if (sender instanceof Player) {
            if (args.length == 1) {
                return StringUtil.copyPartialMatches(args[0], commands, new ArrayList<>());
            } else if (args[0].equals("glow")) {
                if (args.length == 2) return StringUtil.copyPartialMatches(args[1], Arrays.asList("on", "off"), new ArrayList<>());
            }
        }

        return blank;
    }
}
