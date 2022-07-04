package me.altair.cmds;

import me.altair.util.ChatUtil;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

import static org.bukkit.Bukkit.getServer;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;


        if (p.hasPermission("core.gamemode")) {
            if (args.length < 1) {
                p.sendMessage(ChatUtil.fixColor("&4Musisz podać tryb! (0/1/2/3) lub (c/s/a/sp)"));
            } else if (args.length == 1) {
                switch (args[0].toLowerCase(Locale.ROOT)) {
                    case "1":
                    case "c":
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ChatUtil.fixColor("&aZmieniłeś swój tryb gry na &6" + p.getGameMode()));
                        break;
                    case "0":
                    case "s":
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatUtil.fixColor("&aZmieniłeś swój tryb gry na &6" + p.getGameMode()));
                        break;
                    case "2":
                    case "a":
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(ChatUtil.fixColor("&aZmieniłeś swój tryb gry na &6" + p.getGameMode()));
                        break;
                    case "3":
                    case "sp":
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ChatUtil.fixColor("&aZmieniłeś swój tryb gry na &6" + p.getGameMode()));
                        break;
                    default:
                        p.sendMessage(ChatUtil.fixColor("&4Musisz podać tryb! (0/1/2/3) lub (c/s/a/sp)"));
                        break;
                }
            } else {
                Player t = getServer().getPlayer(args[1]);
                if (t != null) {
                    switch (args[0].toLowerCase(Locale.ROOT)) {
                        case "1":
                        case "c":
                            t.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(ChatUtil.fixColor("&6"+p.getDisplayName() + " &2 zmienił twój tryb gry na "+ t.getGameMode()));
                            p.sendMessage(ChatUtil.fixColor("&aZmieniłeś tryb gry gracza &6"+t.getDisplayName() + " &ana &6" + p.getGameMode()));
                            break;
                        case "0":
                        case "s":
                            t.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(ChatUtil.fixColor("&6"+p.getDisplayName() + " &2 zmienił twój tryb gry na "+ t.getGameMode()));
                            p.sendMessage(ChatUtil.fixColor("&aZmieniłeś tryb gry gracza &6"+t.getDisplayName() + " &ana &6" + p.getGameMode()));
                            break;
                        case "2":
                        case "a":
                            t.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(ChatUtil.fixColor("&6"+p.getDisplayName() + " &2 zmienił twój tryb gry na "+ t.getGameMode()));
                            p.sendMessage(ChatUtil.fixColor("&aZmieniłeś tryb gry gracza &6"+t.getDisplayName() + " &ana &6" + p.getGameMode()));
                            break;
                        case "3":
                        case "sp":
                            t.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(ChatUtil.fixColor("&6"+p.getDisplayName() + " &2 zmienił twój tryb gry na "+ t.getGameMode()));
                            p.sendMessage(ChatUtil.fixColor("&aZmieniłeś tryb gry gracza &6"+t.getDisplayName() + " &ana &6" + p.getGameMode()));
                            break;
                        default:
                            p.sendMessage(ChatUtil.fixColor("&4Musisz podać tryb! (0/1/2/3) lub (c/s/a/sp)"));
                            break;
                    }
                } else {
                    p.sendMessage(ChatUtil.fixColor("&4Błąd! podany gracz jest offline!"));
                }
            }
        } else {
            p.sendMessage(ChatUtil.fixColor("&4Nie posiadasz uprawnień do tej komendy!"));
        }

        return false;
    }
}
