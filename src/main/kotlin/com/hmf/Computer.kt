package com.hmf

class Computer :IOpponent {
    override fun play():Element{
        return Element.values().random();
    }
}