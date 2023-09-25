package com.hmf

class Computer :ICanPlay {
    override fun play():Element{
        return Element.values().random();
    }
}