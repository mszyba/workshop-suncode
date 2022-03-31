import http from "../http-common";

class ProductDataService {
    getAll() {
        return http.get("/products");
    }

    getColumnsName() {
        return http.get("/columns");
    }

    findDuplicates(columnName) {
        return http.get(`/duplicates/${columnName}`);
    }

    findUnique(columnName) {
        return http.get(`/unique/${columnName}`)
    }
}

export default new ProductDataService();