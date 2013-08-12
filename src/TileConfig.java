import java.util.HashMap;

/*
copy tile dist from wordsWithFriends:
A:9
B:2
C:2
D:5
E:13
F:2
G:3
H:4
I:8
J:1
K:1
L:4
M:2
N:5
O:8
P:2
Q:1
R:6
S:5
T:7
U:4
V:2
W:2
X:1
Y:2
Z:1
BLANKS:2
 */


public class TileConfig {

    public static final HashMap<String, Integer> tile_config = new HashMap<String, Integer>();

    public TileConfig() {
        tile_config.put("a", 9);
        tile_config.put("b", 2);
        tile_config.put("c", 2);
        tile_config.put("d", 5);
        tile_config.put("e", 13);
        tile_config.put("f", 2);
        tile_config.put("g", 3);
        tile_config.put("h", 4);
        tile_config.put("i", 8);
        tile_config.put("j", 1);
        tile_config.put("k", 1);
        tile_config.put("l", 4);
        tile_config.put("m", 2);
        tile_config.put("n", 5);
        tile_config.put("o", 8);
        tile_config.put("p", 2);
        tile_config.put("q", 1);
        tile_config.put("r", 6);
        tile_config.put("s", 5);
        tile_config.put("t", 7);
        tile_config.put("u", 4);
        tile_config.put("v", 2);
        tile_config.put("w", 2);
        tile_config.put("x", 1);
        tile_config.put("y", 2);
        tile_config.put("z", 1);
        tile_config.put("blank", 2);
    }

}
