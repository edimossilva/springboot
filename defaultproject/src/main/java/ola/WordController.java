package ola;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	@Autowired
	private WordRepository wordRepository;

	@RequestMapping(value = "/word", method = GET)
	public Iterable<Word> index() {
		return wordRepository.findAll();
	}

	@RequestMapping(value = "/word/{id}", method = GET)
	public Word show(@PathVariable("id") long id) {
		return wordRepository.findOne(id);
	}

	@RequestMapping(value = "/word", method = POST)
	public Word save(@RequestBody Word word) {
		wordRepository.save(word);
		return word;
	}

	@RequestMapping(value = "/word/{id}", method = PUT)
	public Word update(@RequestBody Word paramsWord, @PathVariable("id") long id) {
		Word dbWord = wordRepository.findOne(id);
		dbWord.update(paramsWord);
		wordRepository.save(dbWord);
		return dbWord;
	}

	@RequestMapping(value = "/word/{id}", method = DELETE)
	public String delete(@PathVariable("id") long id) {
		wordRepository.delete(id);
		if (wordRepository.findOne(id) == null) {
			return "deleted";
		}
		return "not deleted";
	}

}
