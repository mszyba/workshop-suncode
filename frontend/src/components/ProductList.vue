<template>
    <h1 class="text-center">ProductList</h1>
    <div class="text-center">
      <div class="col-12 text-center">
        <form>
          <label>Choose name of column: </label>
          <select class="form-select"
                  v-model="nameColumn">
            <option class="text-center" disabled value="">Please select one</option>
            <option
                class="text-center"
                v-for="(column, index) in columns" :key="index"
                v-bind:value="column"
            > {{ column }} </option>
          </select>

          <div class="row justify-content-between">
            <div class="col-4 text-center">
              <button class="btn btn-outline-secondary"
                      type="button"
                      @click="searchDuplicates"
              >Search Duplicates</button>
            </div>
            <div class="col-4 text-center">

              <button class="btn btn-outline-secondary"
                      type="button"
                      @click="searchUnique"
              >Search Unique</button>
            </div>
          </div>
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
    };
  },
  methods: {
    getAllProducts() {
      ProductDataService.getAll()
        .then(response => {
          this.productList = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getColumns() {
      ProductDataService.getColumnsName()
        .then(response => {
          this.columns = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    searchDuplicates() {
      ProductDataService.findDuplicates(this.nameColumn)
          .then(response => {
            this.productList = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    },
    searchUnique() {
      ProductDataService.findUnique(this.nameColumn)
          .then(response => {
            this.productList = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.getAllProducts()
    this.getColumns();
    this.searchDuplicates();
    this.searchUnique();
  }
}

</script>
