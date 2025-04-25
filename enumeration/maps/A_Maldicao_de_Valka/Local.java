package enumeration.maps.A_Maldicao_de_Valka;

public enum Local {
    INICIO("Bosque Vazio", "Você acorda em um lugar desconhecido, cercado por árvores e sombras..."),
    TORRE("Torre do Mago", "Lugar onde um mago enlouquecido tenta conter a corrupção de Valkar. Onde a energia arcana instável vibra no ar..."),
    PICO_TEMPESTADE("Pico da Tempestade", "Região de ventos violentos onde relâmpagos acertam aleatoriamente, e uvens escuras se acumulam no céu..."),
    SANTUARIO_FOGO("Santuário de Fogo", "Uma Sala protegida por enigmas e criaturas flamejantes..."),
    FLORESTA("Floresta de Kael'tha", "Floresta viva onde árvores sussurram segredos antigos..."),
    VALE_SOMBRA("Vale das Sombras", "Campo aberto coberto por uma neblina maligna. Sombras dançam entre as árvores..."),
    RUINAS("Ruínas de Tal'Rakar", "Antiga civilização com armadilhas mágicas e enigmas perdidos. Ecos de batalhas passadas ressoam..."),
    CAVERNA("Caverna de Valkar", "Um cheiro de enxofre preenche o ar. Covil do vilão. Portal para o submundo, onde Valkar se esconde...");

    private String name;
    private String description;

    Local(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}

