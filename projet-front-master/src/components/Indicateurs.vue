<template>
    <div class="bloc-indicateurs">
            <div class="indicateur">
                <div class="value-indicateur">{{this.data && this.data.nbLivres ? this.data.nbLivres : "-"}}</div>
                <div class="title-indicateur">Livres publiés</div>
            </div>
            <div class="indicateur">
                <div class="value-indicateur">{{this.data && this.data.nbAuteurs ? this.data.nbAuteurs : "-"}}</div>
                <div class="title-indicateur">Auteurs répertoriés</div>
            </div>
            <div class="indicateur">
                <div class="value-indicateur">{{this.data && this.data.nbGenres ? this.data.nbGenres : "-"}}</div>
                <div class="title-indicateur">Genres différents</div>
            </div>
    </div>
</template>
<script>
export default {
  name: 'Indicateurs',
  props: ["data"]
}
</script>


<style scoped>
.bloc-indicateurs {
    margin-top: 30px;
    padding: 20px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    box-shadow: 0px 2px 6px #0000001A;
    border-radius: 10px;
    opacity: 1;
    display: flex;
}

.indicateur {
    margin: 0 10px;
    padding: 20px;
    background: #F5F7FA 0% 0% no-repeat padding-box;
    box-shadow: 0px 3px 0px #0000001A;
    border-radius: 10px;
    opacity: 1;
    flex:1;
    text-align: center;
}

.indicateur:first-child {
    margin-left: 0px;
}
.indicateur:last-child {
    margin-right: 0px;
}
.value-indicateur {
    font-size: 20px;
    font-weight: bold;
    color: #00AB9B;
}
.title-indicateur {
    font-size: 16px;
    font-weight: bold;
    color: #435058;
}
</style>