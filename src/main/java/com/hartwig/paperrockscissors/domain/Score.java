package com.hartwig.paperrockscissors.domain;

import java.util.Map;

public record Score(Map<Player, GameResults> results) {
}
