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

    public Transaction getTransaction(Long id) throws Exception {
        Optional<Transaction> TransactionOptional = transactionRepository.findById(id);
        if(TransactionOptional.isPresent()){
            return TransactionOptional.get();
        }else{
            throw new Exception("Transaction No Existe");
        }
    }

    public Transaction getTranscationId(Long id) throws Exception {
        Optional<Transaction> transOptional = transactionRepository.findById(id);
        if(transOptional.isPresent()){
            return transOptional.get();
        }else{
            throw new Exception("Transaction No Existe");
        }
    }


    public Transaction patchTransaction(Transaction transaction_param, Long id) throws Exception {
        try {
            Transaction TransactionlDb = getTransaction(id);

            if(transaction_param.getConcept() != null){
                TransactionlDb.setConcept(transaction_param.getConcept());
            }
            if(transaction_param.getAmount() != 0){
                TransactionlDb.setAmount(transaction_param.getAmount());
            }

            return saveTransaction(TransactionlDb);

        } catch (Exception e) {
            throw new Exception("Transaction no se actualizo, porque no existe");
        }
    }

    public String delete(Long id){
        transactionRepository.deleteById(id);
        return "Transaction eliminada Exitosamente";
    }


}
