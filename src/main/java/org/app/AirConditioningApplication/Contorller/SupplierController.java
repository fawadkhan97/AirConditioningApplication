package org.app.AirConditioningApplication.Contorller;

import org.app.AirConditioningApplication.Model.Supplier;
import org.app.AirConditioningApplication.Service.SupplierService;
import org.app.AirConditioningApplication.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/list")
    public ApiResponse list() {
        return supplierService.showAll();
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long Id) {
        return supplierService.delete(Id);
    }

    @GetMapping("/getByID")
    public ResponseEntity<Object> getById(@RequestParam Long Id) {
        return supplierService.getById(Id);
    }

    @PostMapping("/buyProductFromSupplier")
    @ResponseBody
    public void buyProductFromSupplier(@RequestBody Supplier supplier, @RequestParam(name = "quantity") Integer quantityToBuy) {
        supplierService.buyProductsFromSupplier(supplier, quantityToBuy);
    }

    @PostMapping("/buyMultipleProductFromSupplier")
    @ResponseBody
    public void buyMultipleProductFromSupplier(@RequestBody List<Supplier> supplierList) {
        supplierService.buyMultipleProductsFromSupplier(supplierList);
    }

}
