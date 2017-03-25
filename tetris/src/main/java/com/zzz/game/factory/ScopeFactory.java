package com.zzz.game.factory;

import com.zzz.game.pojo.Scope;

import java.util.Random;

/**
 * Created by zd on 2017/3/25.
 */
public class ScopeFactory {

    private static Random random = new Random();
//    private static int[][][][] points = {{ {
//            {1, 0, 0, 0},
//            {1, 0, 0, 0},
//            {1, 0, 0, 0},
//            {1, 0, 0, 0}
//    }
//    }};

    private static int[][][][] points = {{{
            {1, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    }, {
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
    }
    },{{
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
    }
    },{{
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    }, {
            {0, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0}
    }, {
            {0, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0}
    }, {
            {0, 1, 0, 0},
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0}
    }
    }};


    public static Scope getNextScope(int x,int y) {
        int[][][] p = points[random.nextInt(points.length)];
        return new Scope(p,x,y);
    }

    public void Random(int len){

    }

}
