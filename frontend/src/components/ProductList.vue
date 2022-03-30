<template>
    <h1>ProductList</h1>
    <div class="row justify-content-between">
      <div class="col-4">
        <form id="unique">
          <label>Choose unique: </label>
          <select class="form-select">
            <option value="">Please select one</option>
            <option
                v-for="(column, index) in columns" :key="index"
                v-bind:value="column.value"> {{column}} </option>
          </select>
        </form>
      </div>

      <div class="col-4">
        <form id="duplicates">
          <label>Choose duplicates: </label>
          <select class="form-select">
            <option selected disabled value="">Please select one</option>
            <option
                v-for="(column, index) in columns" :key="index"
                v-bind:value="column.value"> {{column}} </option>
          </select>
        </form>
      </div>
    </div>
    <div class="container">

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

import ProductDataService from "@/services/ProductDataService";

export default {
  name: "ProductList",
  data() {
    return {
      productList: [],
      columns: [],
      selected: ""
    };
  },
  methods: {
    retrieveProducts() {
      ProductDataService.getAll()
        .then(response => {
          this.productList = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getColumns() {
      ProductDataService.getColumnsName()
        .then(response => {
          this.columns = response.data;
          console.log(response.data)
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveProducts();
    this.getColumns();
  }
}

</script>
