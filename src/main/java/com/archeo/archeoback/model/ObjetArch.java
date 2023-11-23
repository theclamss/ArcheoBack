package com.archeo.archeoback.model;

import jakarta.persistence.*;





    @Entity
    public class ObjetArch {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String type;
        private String titre;
        private String historique;

        @ManyToOne
        private Lieux decouverte;



        @ManyToOne
        private Lieux conservation;

        @ManyToOne
        private Lieux lieuCreation;


        private Long numInv;

        private String matieres;

        private String dimensions;

        private String discription;

        private String etatDeConservation;

        private String auteurDeLaFiche;

        private String technique;


        //Photo

        //// numero d'inventaire

        //technique

        //matieres

        //dimensions

        //discription

        //etat de conversation

        //auteur de la fiche




        private String documentation;

        // Constructors, getters, and setters

        // Constructors
        public ObjetArch() {
        }

        public ObjetArch(String type, String titre, String historique, Lieux decouverte,
                                  Lieux conservation, Lieux lieuCreation, String documentation) {
            this.type = type;
            this.titre = titre;
            this.historique = historique;
            this.decouverte = decouverte;
            this.conservation = conservation;
            this.lieuCreation = lieuCreation;
            this.documentation = documentation;
        }


    }


