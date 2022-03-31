import {createWebHistory, createRouter} from "vue-router";

const routes = [
    {
        path: "/",
        alias: "/products",
        name: "products",
        component: () => import("./components/ProductList")
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;