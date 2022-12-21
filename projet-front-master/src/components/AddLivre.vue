<template>
    <div class="add-livres py-3">
        <div class="row">
            <div class="col-6">
                <h1 v-if="!this.$route.params.id" class="mb-3">Ajout d'un nouveau livre</h1>
                <h1 v-else class="mb-3">Modification du livre {{this.$route.params.id }} </h1>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">Nom</span>
                    <input type="text" v-model="form.nom" class="form-control" placeholder="Nom du livre" aria-label="nom" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">Editeur</span>
                    <input type="text" v-model="form.editeur" class="form-control" placeholder="Editeur" aria-label="Editeur" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Nombre de pages</span>
                    <input type="number" v-model="form.nbPages" class="form-control" placeholder="Nombre de pages" aria-label="Nombre de pages" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">Date de parution</span>
                    <input type="date" v-model="form.dateParution" class="form-control" placeholder="Date de parution" aria-label="Date de parution" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">Lieu de parution</span>
                    <input type="text" v-model="form.lieuParution" class="form-control" placeholder="Lieu de parution" aria-label="Lieu de parution" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Genre</label>
                    <select v-model="form.genre" class="form-select" id="inputGroupSelect01">
                        <option selected>Choisir le type</option>
                        <option value="ROMAN">ROMAN</option>
                        <option value="MANGA">MANGA</option>
                        <option value="BD">BD</option>
                        <option value="POESIE">POESIE</option>
                        <option value="NOUVELLE">NOUVELLE</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Auteur</label>
                    <select v-if="listeAuteurs" v-model="form.auteur" class="form-select" id="inputGroupSelect01">
                        <option selected>Choisir l'auteur</option>
                        <option v-for="auteur in listeAuteurs" :key="auteur.id" :value="auteur">{{auteur.prenom}} {{auteur.nom}}</option>
                    </select>
                </div>
                <button type="button" class="btn btn-secondary" @click="reset()">Reset</button>
                <button type="button" class="btn btn-primary ml-2" @click="actionLivre()">{{this.$route.params.id ? "Modifier le livre" : "Ajouter le livre"}}</button>
            </div>
        </div>
    </div>
</template>
<script>
import { URI } from './../env'
export default {
    name: 'AddLivre',
    data () {
    return {
      listeAuteurs: null,
      form : {
          nom: null,
          editeur: null,
          nbPages: null,
          dateParution: null,
          lieuParution: null,
          genre: null,
          auteur: null
      }
    }
  },

  mounted () {
      this.axios.get(URI + 'auteurs/').then((response) => {
          this.listeAuteurs = response.data
        }).catch(() => {
            this.$bvToast.toast("Impossible de récupérer la liste des auteurs", {title: 'Une erreur s\'est produite',variant: 'danger',solid: true,autoHideDelay: 10000, toaster: 'b-toaster-bottom-right'})
            });
      if(this.$route.params.id){
          this.axios.get(URI + 'livres/'+ this.$route.params.id).then((response) => {
          this.form = response.data
        }).catch(() => {
            this.$bvToast.toast("Impossible de récupérer le pokémon numéro : " + this.$route.params.id + " pour édition", {title: 'Une erreur s\'est produite',variant: 'danger',solid: true,autoHideDelay: 10000, toaster: 'b-toaster-bottom-right'})
            });
        }

  },
  methods: {
      actionLivre() {
        let request = {
            id: this.$route.params.id ? this.$route.params.id : null,
            nom: this.form.nom,
            editeur: this.form.editeur,
            nbPages: this.form.nbPages,
            dateParution: this.form.dateParution,
            lieuParution: this.form.lieuParution,
            genre: this.form.genre,
            auteur: this.form.auteur
        }
        if (!this.$route.params.id) {
            this.addLivre(request);
        } else {
            this.updatelivre(request);
        }
    },
    addLivre(request) {
                this.axios.post(URI + 'livres/', request).then(() => {
                    this.$bvToast.toast("Le livre a bien été ajouté ! ", {
                        title: 'Insertion réussie !',
                        variant: 'success',
                        solid: true,
                        autoHideDelay: 10000,
                        toaster: 'b-toaster-bottom-right'
                    })
                    setTimeout(() => {this.$router.push({ name: 'mainScreen'})}, 1500);
                }).catch(() => {
                    this.$bvToast.toast("L'ajout du livre a échoué", {
                        title: 'Une erreur s\'est produite',
                        variant: 'danger',
                        solid: true,
                        autoHideDelay: 10000,
                        toaster: 'b-toaster-bottom-right'
                    })
                });
            },
            updatelivre(request) {
                this.axios.put(URI + 'livres/' + request.id + '/', request).then(() => {
                    this.$bvToast.toast("Le livre" + request.nom + " a bien été modifié ! ", {
                        title: 'Modification réussie !',
                        variant: 'success',
                        solid: true,
                        autoHideDelay: 10000,
                        toaster: 'b-toaster-bottom-right'
                    })
                    setTimeout(() => {this.$router.push({ name: 'home'})}, 1500);
                }).catch(() => {
                    this.$bvToast.toast("La modification du livre a échoué", {
                        title: 'Une erreur s\'est produite',
                        variant: 'danger',
                        solid: true,
                        autoHideDelay: 10000,
                        toaster: 'b-toaster-bottom-right'
                    })
                });
            },
    reset() {
        this.form.nom = null,
        this.form.editeur = null,
        this.form.nbPages = null,
        this.form.dateParution = null,
        this.form.lieuParution = null,
        this.form.genre = null,
        this.form.auteur = null
    }
}
}
</script>
<style scoped>
.input-group-text {
    width: 150px;
    border-radius: 0.25em 0 0 0.25em;
}

.form-select {
    width: 370px;
}
.add-livres {
    margin-top: 30px;
    padding: 20px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    box-shadow: 0px 2px 6px #0000001A;
    border-radius: 10px;
    opacity: 1;
}
</style>
