package mindtech.proyecto.Servicios;

import mindtech.proyecto.entidades.Profile;
import mindtech.proyecto.entidades.Transaction;
import mindtech.proyecto.repositorio.ProfileRepository;
import mindtech.proyecto.repositorio.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository  transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionService() {
    }

    public Transaction saveTransaction(Transaction Transaction_param){
        return transactionRepository.save(Transaction_param);
    }
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactions(Long id) throws Exception {
        Optional<Transaction> TransactionOptional = transactionRepository.findById(id);
        if(TransactionOptional.isPresent()){
            return TransactionOptional.get();
        }else{
            throw new Exception("Transaction No Existe");
        }
    }

}
