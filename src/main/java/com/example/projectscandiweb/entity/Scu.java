package com.example.projectscandiweb.entity;


import java.util.HashSet;
import java.util.Set;

public enum Scu {
    furnit10, mfurnit11, furnit12,
    electr1000, electr1100, electr1200,
    pro333, pro444, pro555, pro777, pro888;

    public static Set<Scu> getForProductType(ProductType productType) {
        switch (productType) {
            case Furniture:
                return Set.of(furnit10, mfurnit11, furnit12);
            case Food:
                return Set.of(pro333, pro444, pro555, pro777, pro888);
            case Electronics:
                return Set.of(electr1000, electr1100, electr1200);
        }
        return new HashSet<>();
    }

}
