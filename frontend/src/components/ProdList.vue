<template>
  <div class="container">
    <h1>TESTOWY</h1>
<div class="container-fluid">
    <table class="table table-hover">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Kolumna 1</th>
        <th scope="col">Kolumna 2</th>
        <th scope="col">Kolumna 3</th>
        <th scope="col">Kolumna 4</th>
      </tr>
      </thead>
      <tbody >
      <tr v-for="(product, index) in productList" :key="index">
        <td>{{product.id}}</td>
        <td>{{product.kolumna1}}</td>
        <td>{{product.kolumna2}}</td>
        <td>{{product.kolumna3}}</td>
        <td>{{product.kolumna4}}</td>
      </tr>
      </tbody>
    </table>
  </div>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'ProdList',
  mounted: function () {
    this.getProd()
  },
  data: function () {
    return {
      productList: []
    }
  },
  methods: {
    getProd: function () {
      let self = this;
      const url = 'http://localhost:8080/api/prod'
      axios.get(url, {
        dataType: 'json',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        mode: 'no-cors',
        credentials: 'include'
      })
          .then(function (response) {
            self.productList = response.data
          })
          .catch(function (error) {
            console.log(error)
          })
    }
  }
}


</script>

<style scoped>

</style>