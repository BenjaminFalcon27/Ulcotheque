<template>
  <div id="app">
    <Header />
    <div class="container">
      <router-view class="app-content" ></router-view>
    </div>
    <Footer />
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'

export default {
  name: 'App',
  components: {
    Header,
    Footer
  }
}
</script>

<style>
html, body, #app {
  background: #F5F7FA
}
</style>
