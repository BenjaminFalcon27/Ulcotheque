<template>
    <nav class="navbar navbar-expand-lg navbar-light background-navbar">
    <div class="container-fluid">
        <router-link to="/">
            <a class="navbar-brand" href="#"><span class="logo-one">ULCO'</span><span class="logo-two">thèque</span></a>
        </router-link>
    <ul class="navbar-nav">
        <li class="nav-item">
          <router-link to="/new">
                <button type="button" class="btn btn-info">Ajouter un livre</button>
            </router-link>
        </li>
    </ul>
    </div>
    </nav>
</template>
<style scoped>
.logo-two {
    color: #00AB9B!important;
}
.logo-one {
    color: #fff!important;
}
.background-navbar {
    background: #232D4B!important;
    font-weight: bold;
}
</style>