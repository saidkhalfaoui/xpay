package com.henripay.sepadd.dataaccess;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.ImplFirebaseTrampolines;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static io.netty.util.internal.ObjectUtil.checkNotNull;

@Component
public class FireStoreDatabase {

    @Value("${app.database.url}")
    private String url;

    @Value("${app.database.name}")
    private String name;


    public Firestore getDatabase() throws IOException {

        if (database == null) {


            InitDataBase();
        }
        return database;
    }

    private static Firestore database;


    private Firestore InitDataBase() throws IOException {


        //   InputStream serviceAccount = TransactionFireStoreDAO.class.getClassLoader().getResourceAsStream("firestoretest-8231d-firebase-adminsdk-ugmps-bd89b0fe7c.json");
        //    GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setDatabaseUrl(url)
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(options);
        checkNotNull(app, "FirebaseApp must not be null");
        String projectId = ImplFirebaseTrampolines.getProjectId(app);
      /*  checkArgument(!Strings.isNullOrEmpty(projectId),
                "Project ID is required for accessing Firestore. Use a service account credential or "
                        + "set the project ID explicitly via FirebaseOptions. Alternatively you can also "
                        + "set the project ID via the GOOGLE_CLOUD_PROJECT environment variable.");
   */
        FirestoreOptions userOptions = ImplFirebaseTrampolines.getFirestoreOptions(app);
        FirestoreOptions.Builder builder = userOptions != null
                ? userOptions.toBuilder() : FirestoreOptions.newBuilder();


        database = builder
                // CredentialsProvider has highest priority in FirestoreOptions, so we set that.
                .setCredentialsProvider(
                        FixedCredentialsProvider.create(ImplFirebaseTrampolines.getCredentials(app)))
                .setProjectId(projectId)
                .setDatabaseId(name)
                .build()
                .getService();

        return database;


    }
}
