<template>
  <div class="container">
    <div class="container">
      <h1 class="text-center">Choose: </h1>
    </div>

<!--    <div class="row justify-content-between">-->
<!--      <div class="col-4">-->
<!--        <form>-->
<!--          <select class="form-select">-->
<!--            <option value="1" name="1"></option>-->
<!--            <option value="1"></option>-->
<!--          </select>-->
<!--        </form>-->
<!--      </div>-->
<!--    </div>-->
    <FormColumn />
  <ProductList />
  </div>
</template>

<script>
import ProductList from "./components/ProductList";
import FormColumn from "@/components/FormColumn";

export default {
  name: 'App',
  components: {
    FormColumn,
    ProductList
  }
}
</script>

