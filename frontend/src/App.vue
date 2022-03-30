<template>
  <p>Testowy paragraf</p>
  <ProdList />
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import ProdList from "./components/ProdList";

export default {
  name: 'App',
  components: {
    // HelloWorld
    ProdList
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
